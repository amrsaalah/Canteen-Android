package com.canteen.presenters.displayModels.category

import androidx.annotation.DrawableRes

/**
 * Created by Amr Salah on 6/6/2019.
 */
data class CategoryItem(
    val id: Int,
    val name: String,
    val imgUrl: String? = null,
    @DrawableRes val placeholder: Int? = null
)