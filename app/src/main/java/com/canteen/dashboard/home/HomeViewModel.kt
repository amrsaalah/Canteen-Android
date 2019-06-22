package com.canteen.dashboard.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.canteen.base.BaseViewModel
import com.canteen.base.BusEvents
import com.canteen.base.Session
import com.canteen.base.utils.EventBus
import com.canteen.base.utils.SingleLiveEvent
import com.canteen.presenters.category.ICategoryPresenter
import com.canteen.presenters.displayModels.category.CategoryItem
import com.canteen.presenters.displayModels.product.ProductItem
import com.canteen.presenters.product.IProductPresenter
import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

/**
 * Created by Amr Salah on 5/26/2019.
 */

class HomeViewModel @Inject constructor(
    private val categoryPresenter: ICategoryPresenter,
    private val productPresenter: IProductPresenter,
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

    override val notifyFavChange: SingleLiveEvent<Int> = SingleLiveEvent()
    override val loading: MutableLiveData<Boolean> = MutableLiveData()

    init {
        Timber.d(session.currentUser.toString())

        viewModelScope.launch {
            eventBus.asChannel<BusEvents>().consumeEach { event ->
                when (event) {
                    is BusEvents.ProductFavoriteChangeEvent -> {
                        topRatedProducts.value?.let { products ->
                            val product = products.firstOrNull { it.productId == event.productId }
                            if (product != null) {
                                product.isFavorite = event.isFavorite
                                product.favIcon = event.favIcon
                                notifyFavChange.value = products.indexOf(product)
                            }
                        }
                    }

                    else -> {
                    }
                }
            }
        }
    }


    override fun favButtonClicked(productItem: ProductItem) {
        viewModelScope.launch {
            productPresenter.handleLikeButtonClicked(productItem)
        }
    }
}