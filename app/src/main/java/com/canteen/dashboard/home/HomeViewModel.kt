package com.canteen.dashboard.home

import com.canteen.base.BaseViewModel
import com.canteen.base.utils.EventBus
import com.canteen.presenters.category.ICategoryPresenter
import javax.inject.Inject

/**
 * Created by Amr Salah on 5/26/2019.
 */

class HomeViewModel @Inject constructor(
    categoryPresenter: ICategoryPresenter,
    eventBus: EventBus
) : BaseViewModel(eventBus),
    IHomeViewModel {

    companion object {
        private const val TAG = "HomeViewModel"
    }


    init {

    }


}