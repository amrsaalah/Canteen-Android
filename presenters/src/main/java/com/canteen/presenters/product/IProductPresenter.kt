package com.canteen.presenters.product

import com.canteen.data.entities.Product

/**
 * Created by Amr Salah on 5/31/2019.
 */
interface IProductPresenter {

    suspend fun getTopRatedProducts(): List<Product>
}