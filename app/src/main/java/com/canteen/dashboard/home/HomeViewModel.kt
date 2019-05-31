package com.canteen.dashboard.home

import com.canteen.base.BaseViewModel
import com.canteen.presenters.category.ICategoryPresenter
import javax.inject.Inject

/**
 * Created by Amr Salah on 5/26/2019.
 */

class HomeViewModel @Inject constructor(categoryPresenter: ICategoryPresenter) : BaseViewModel(),
    IHomeViewModel {

    companion object {
        private const val TAG = "HomeViewModel"
    }


    init {

    }


}