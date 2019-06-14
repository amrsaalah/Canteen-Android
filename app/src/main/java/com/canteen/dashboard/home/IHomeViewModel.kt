package com.canteen.dashboard.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.canteen.base.IBaseViewModel
import com.canteen.presenters.displayModels.category.CategoryItem

/**
 * Created by Amr Salah on 5/26/2019.
 */
interface IHomeViewModel : IBaseViewModel {
    val categories: LiveData<List<CategoryItem>>
    val loading: MutableLiveData<Boolean>
}