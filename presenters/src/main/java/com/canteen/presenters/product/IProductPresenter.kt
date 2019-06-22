package com.canteen.presenters.product

import com.canteen.presenters.displayModels.product.ProductItem

/**
 * Created by Amr Salah on 5/31/2019.
 */
interface IProductPresenter {

    suspend fun getTopRatedProducts(): List<ProductItem>
    suspend fun handleLikeButtonClicked(productItem: ProductItem)
}