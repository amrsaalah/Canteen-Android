package com.canteen.presenters.category

import com.canteen.presenters.displayModels.category.CategoryItem

/**
 * Created by Amr Salah on 5/26/2019.
 */
interface ICategoryPresenter {

    suspend fun getCategories(): List<CategoryItem>
}