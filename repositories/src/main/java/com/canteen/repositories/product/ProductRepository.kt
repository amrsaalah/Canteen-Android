package com.canteen.repositories.product

import com.canteen.base.utils.EventBus
import com.canteen.data.entities.Product
import com.canteen.data.localDataSource.entry.IEntryLocalDataSource
import com.canteen.data.localDataSource.product.IProductLocalDataSource
import com.canteen.network.remoteDataSource.product.IProductRemoteDataSource
import com.canteen.repositories.BaseRepository
import com.canteen.repositories.data.product.EProductOrder.ID
import com.canteen.repositories.data.product.EProductOrder.RATING
import com.canteen.repositories.data.product.EProductSort.ASC
import com.canteen.repositories.data.product.EProductSort.DESC
import com.canteen.repositories.data.product.ProductFilter
import javax.inject.Inject

/**
 * Created by Amr Salah on 5/31/2019.
 */
class ProductRepository @Inject constructor(
    private val productLocalDataSource: IProductLocalDataSource,
    private val productRemoteDataSource: IProductRemoteDataSource,
    private val eventBus: EventBus,
    private val entryLocalDataSource: IEntryLocalDataSource
) : BaseRepository(entryLocalDataSource), IProductRepository {
    override suspend fun getProductsFilteredList(productFilter: ProductFilter): List<Product> {
        var orderBy = ""
        orderBy += when (productFilter.orderBy) {
            ID -> "remoteId"
            RATING -> "rating"
        }

        orderBy += when (productFilter.sortBy) {
            ASC -> "ASC"
            DESC -> "DESC"
        }

        return productLocalDataSource.getProductsFilteredList(
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