package com.canteen.dashboard.home

import androidx.lifecycle.LiveData
import com.canteen.presenters.displayModels.category.CategoryItem

/**
 * Created by Amr Salah on 5/26/2019.
 */
interface IHomeViewModel {
    val categories: LiveData<List<CategoryItem>>
}