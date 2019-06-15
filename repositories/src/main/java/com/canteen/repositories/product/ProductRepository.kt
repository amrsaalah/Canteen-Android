package com.canteen.repositories.product

import com.canteen.base.Session
import com.canteen.base.utils.EventBus
import com.canteen.data.entities.Category
import com.canteen.data.entities.Product
import com.canteen.data.localDataSource.category.ICategoryLocalDataSource
import com.canteen.data.localDataSource.entry.IEntryLocalDataSource
import com.canteen.data.localDataSource.product.IProductLocalDataSource
import com.canteen.network.api.ProductFilterRequest
import com.canteen.network.api.ProductResponse
import com.canteen.network.api.ProductSearchRequest
import com.canteen.network.remoteDataSource.product.IProductRemoteDataSource
import com.canteen.repositories.BaseRepository
import com.canteen.repositories.ITasksHandler
import com.canteen.repositories.data.product.EProductOrder.ID
import com.canteen.repositories.data.product.EProductOrder.RATING
import com.canteen.repositories.data.product.EProductSort.ASC
import com.canteen.repositories.data.product.EProductSort.DESC
import com.canteen.repositories.data.product.ProductFilter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import timber.log.Timber
import javax.inject.Inject

/**
 * Created by Amr Salah on 5/31/2019.
 */
class ProductRepository @Inject constructor(
    private val productLocalDataSource: IProductLocalDataSource,
    private val productRemoteDataSource: IProductRemoteDataSource,
    private val categoryLocalDataSource: ICategoryLocalDataSource,
    private val eventBus: EventBus,
    private val entryLocalDataSource: IEntryLocalDataSource,
    private val tasksHandler: ITasksHandler,
    private val session: Session
) : BaseRepository(entryLocalDataSource), IProductRepository {

    override suspend fun likeProduct(productId: Int): Product {
        val product = productLocalDataSource.getProductById(productId)!!
        product.isFavorite = true
        productLocalDataSource.updateProduct(product)
        return productLocalDataSource.getProductById(productId)!!
    }

    override suspend fun unLikeProduct(productId: Int): Product {
        val product = productLocalDataSource.getProductById(productId)!!
        product.isFavorite = false
        productLocalDataSource.updateProduct(product)
        return productLocalDataSource.getProductById(productId)!!
    }


    override suspend fun getFavoriteProducts(): List<Product> = withContext(Dispatchers.IO) {
        val api = productRemoteDataSource.getFavoriteProducts()
        if (api.status.isSuccessful()) {
            val response = api.data!!
            Timber.d(response.toString())
            val products: List<Product> = response.map { mapRemoteProductToLocal(it) }

            productLocalDataSource.insertOrUpdateProducts(products)
            val fav = productLocalDataSource.getFavoriteProducts()
            fav
        } else {
            productLocalDataSource.getFavoriteProducts()
        }
    }


    override suspend fun getProductsFilteredList(productFilter: ProductFilter): List<Product> =
        withContext(Dispatchers.IO) {
            val request = ProductFilterRequest(
                productFilter.pageNumber,
                productFilter.pageSize,
                when (productFilter.orderBy) {
                    ID -> "ProductId"
                    RATING -> "Rating"
                },
                when (productFilter.sortBy) {
                    ASC -> "ASC"
                    DESC -> "DESC"
                },
                ProductSearchRequest(
                    productFilter.query,
                    if (productFilter.categoryId != null) categoryLocalDataSource.getCategoryById(
                        productFilter.categoryId
                    )!!.remoteId else null,
                    productFilter.ratingFrom,
                    productFilter.ratingTo
                )
            )
            val api = productRemoteDataSource.getProductsFilteredList(request)

            if (api.status.isSuccessful()) {
                val response = api.data!!
                val products = response.products.map { mapRemoteProductToLocal(it) }
                productLocalDataSource.insertOrUpdateProducts(products)
                var orderBy = ""
                orderBy += when (productFilter.orderBy) {
                    ID -> "remoteId"
                    RATING -> "rating"
                }

                orderBy += when (productFilter.sortBy) {
                    ASC -> "ASC"
                    DESC -> "DESC"
                }

                productLocalDataSource.getProductsFilteredList(
                    productFilter.pageNumber,
                    productFilter.pageSize,
                    orderBy,
                    productFilter.categoryId,
                    productFilter.ratingFrom,
                    productFilter.ratingTo,
                    productFilter.query
                )
            } else {
                var orderBy = ""
                orderBy += when (productFilter.orderBy) {
                    ID -> "remoteId"
                    RATING -> "rating"
                }

                orderBy += when (productFilter.sortBy) {
                    ASC -> "ASC"
                    DESC -> "DESC"
                }

                productLocalDataSource.getProductsFilteredList(
                    productFilter.pageNumber,
                    productFilter.pageSize,
                    orderBy,
                    productFilter.categoryId,
                    productFilter.ratingFrom,
                    productFilter.ratingTo,
                    productFilter.query
                )
            }
        }


    override suspend fun syncProducts() = withContext(Dispatchers.IO) {
        val response = productRemoteDataSource.getAllProducts()
        if (response.status.isSuccessful()) {
            val data = response.data!!

            val products: List<Product> = data.map { mapRemoteProductToLocal(it) }

            productLocalDataSource.insertAll(products)
        }
    }


    private suspend fun mapRemoteProductToLocal(response: ProductResponse): Product {

        val localCategory = categoryLocalDataSource.getCategoryByRemoteId(response.categoryId)
        val localCategoryId = localCategory?.id
            ?: categoryLocalDataSource.insert(
                Category(
                    response.categoryName,
                    remoteId = response.categoryId
                )
            ).toInt()

        return Product(
            response.productName,
            response.productDescription,
            localCategoryId,
            response.price,
            response.rating,
            remoteId = response.productId,
            imageUrl = response.imageUrl,
            remoteCategoryId = response.categoryId,
            isFavorite = if (response.favorites == null) true else response.favorites!!.any { fav -> fav.userId == session.currentUser?.id }
        )
    }

}