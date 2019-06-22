package com.canteen.presenters.product

import com.canteen.base.BusEvents
import com.canteen.base.utils.EventBus
import com.canteen.base.utils.ResourceProvider
import com.canteen.data.entities.Product
import com.canteen.presenters.R
import com.canteen.presenters.displayModels.product.ProductItem
import com.canteen.repositories.category.ICategoryRepository
import com.canteen.repositories.data.product.EProductOrder
import com.canteen.repositories.data.product.EProductSort
import com.canteen.repositories.data.product.ProductFilter
import com.canteen.repositories.product.IProductRepository
import com.canteen.repositories.user.IUserRepository
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by Amr Salah on 5/31/2019.
 */
class ProductPresenter @Inject constructor(
    private val userRepository: IUserRepository,
    private val productRepository: IProductRepository,
    private val categoryRepository: ICategoryRepository,
    private val eventBus: EventBus,
    private val resourceProvider: ResourceProvider
) : IProductPresenter {


    init {
        GlobalScope.launch {
            eventBus.asChannel<Product>().consumeEach {
                eventBus.send(mapProductToProductFavChangeEvent(it))
            }
        }
    }

    override suspend fun handleLikeButtonClicked(productItem: ProductItem) {
        val productChange = if (productItem.isFavorite) {
            mapProductToProductFavChangeEvent(productRepository.unLikeProduct(productItem.productId))
        } else {
            mapProductToProductFavChangeEvent(productRepository.likeProduct(productItem.productId))
        }

        eventBus.send(productChange)
    }

    override suspend fun getTopRatedProducts(): List<ProductItem> {
        val productFilter = ProductFilter(1, 5, EProductOrder.RATING, EProductSort.DESC)
        val products = productRepository.getProductsFilteredList(productFilter)

        return products.map { product -> mapProductToProductItem(product) }
    }


    private suspend fun mapProductToProductItem(product: Product): ProductItem {
        return ProductItem(
            product.id, product.categoryId, product.name, product.description,
            categoryRepository.getCategoryById(product.categoryId).name,
            resourceProvider.getString(R.string.from_price, product.price),
            product.rating.toString(),
            product.imageUrl,
            product.isFavorite,
            getFavIconFromFavoriteState(product.isFavorite),
            R.drawable.placeholder
        )
    }


    private fun mapProductToProductFavChangeEvent(product: Product): BusEvents.ProductFavoriteChangeEvent {
        return BusEvents.ProductFavoriteChangeEvent(
            product.id,
            product.isFavorite,
            getFavIconFromFavoriteState(product.isFavorite)
        )
    }


    private fun getFavIconFromFavoriteState(isFav: Boolean): Int {
        return if (isFav) R.drawable.red_heart else R.drawable.heart
    }
}