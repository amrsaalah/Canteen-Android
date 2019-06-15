package com.canteen.dashboard.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.canteen.base.BaseViewModel
import com.canteen.base.Session
import com.canteen.base.utils.EventBus
import com.canteen.base.utils.SingleLiveEvent
import com.canteen.presenters.category.ICategoryPresenter
import com.canteen.presenters.displayModels.category.CategoryItem
import com.canteen.presenters.displayModels.product.ProductItem
import com.canteen.presenters.product.ProductPresenter
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

/**
 * Created by Amr Salah on 5/26/2019.
 */

class HomeViewModel @Inject constructor(
    private val categoryPresenter: ICategoryPresenter,
    private val productPresenter: ProductPresenter,
    private val eventBus: EventBus,
    private val session: Session
) : BaseViewModel(eventBus),
    IHomeViewModel {


    override val categories: LiveData<List<CategoryItem>> = liveData {
        loading.value = true
        emit(categoryPresenter.getCategories())
        loading.value = false
    }

    override val topRatedProducts: LiveData<List<ProductItem>> = liveData {
        emit(productPresenter.getTopRatedProducts())
    }

    override val notifyFavChange: SingleLiveEvent<ProductItem> = SingleLiveEvent()
    override val loading: MutableLiveData<Boolean> = MutableLiveData()

    init {
        Timber.d(session.currentUser.toString())

    }


    override fun favButtonClicked(productItem: ProductItem) {
        viewModelScope.launch {
            notifyFavChange.value = productPresenter.handleLikeButtonClicked(productItem)
        }
    }
}