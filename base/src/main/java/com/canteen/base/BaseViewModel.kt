package com.canteen.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.canteen.base.utils.EventBus
import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.launch

/**
 * Created by Amr Salah on 5/19/2019.
 */
abstract class BaseViewModel(private val eventBus: EventBus) : ViewModel(), IBaseViewModel {


    init {
        viewModelScope.launch {
            eventBus.asChannel<BusEvents>().consumeEach {
                when (it) {
                    is BusEvents.ErrorEvent -> {
                        toastMessage.value = it.message
                    }

                    else -> {

                    }
                }
            }
        }
    }

    val toastMessage: MutableLiveData<String> = MutableLiveData()
}