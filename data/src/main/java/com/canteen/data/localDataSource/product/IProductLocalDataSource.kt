package com.canteen.data.localDataSource.product

import com.canteen.data.entities.Product
import com.canteen.data.localDataSource.BaseLocalDataSource

/**
 * Created by Amr Salah on 5/19/2019.
 */
interface IProductLocalDataSource : BaseLocalDataSource<Product> {

    suspend fun getAllProducts(): List<Product>
    suspend fun getProductsByCategoryId(categoryId: Int): List<Product>
    suspend fun getProductsFilteredList(
        pageNumber: Int,
        pageSize: Int,
        orderBy: String,
        categoryId: Int? = null,
        ratingFrom: Double? = null,
        ratingTo: Double? = null,
        search: String? = null
    ): List<Product>

    suspend fun getProductByProductRemoteId(remoteId: String): Product?

    suspend fun getFavoriteProducts(): List<Product>


    suspend fun insertOrUpdateProducts(products: List<Product>)

    suspend fun updateProduct(product: Product)
    suspend fun getProductById(productId: Int): Product?

}