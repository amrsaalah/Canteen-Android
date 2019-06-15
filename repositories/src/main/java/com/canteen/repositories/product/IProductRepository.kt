package com.canteen.repositories.product

import com.canteen.data.entities.Product
import com.canteen.repositories.data.product.ProductFilter

/**
 * Created by Amr Salah on 5/31/2019.
 */
interface IProductRepository {

    suspend fun getProductsFilteredList(productFilter: ProductFilter): List<Product>
    suspend fun syncProducts()
    suspend fun getFavoriteProducts(): List<Product>
}