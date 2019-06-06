package com.canteen.dashboard.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.canteen.base.BaseViewModel
import com.canteen.base.utils.EventBus
import com.canteen.presenters.category.ICategoryPresenter
import com.canteen.presenters.displayModels.category.CategoryItem
import javax.inject.Inject

/**
 * Created by Amr Salah on 5/26/2019.
 */

class HomeViewModel @Inject constructor(
    private val categoryPresenter: ICategoryPresenter,
    eventBus: EventBus
) : BaseViewModel(eventBus),
    IHomeViewModel {

    companion object {
        private const val TAG = "HomeViewModel"
    }

    override val categories: LiveData<List<CategoryItem>> =
        liveData { emit(categoryPresenter.getCategories()) }

}