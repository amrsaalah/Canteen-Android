package com.canteen.presenters.displayModels.product

import androidx.annotation.DrawableRes

/**
 * Created by Amr Salah on 6/15/2019.
 */
data class ProductItem(
    val productId: Int,
    val categoryId: Int,
    val productName: String,
    val productDescription: String,
    val categoryName: String,
    val price: String,
    val rating: String,
    val imgUrl: String? = null,
    var isFavorite: Boolean,
    @DrawableRes var favIcon: Int? = null,
    @DrawableRes val placeholder: Int? = null
)