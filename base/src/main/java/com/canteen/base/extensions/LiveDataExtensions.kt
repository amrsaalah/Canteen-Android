package com.canteen.base.extensions

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.canteen.base.utils.SingleLiveEvent

/**
 * Created by Amr Salah on 6/21/2019.
 */
fun <T> MutableLiveData<T>.notifyObserver() {
    this.value = this.value
}


fun <T> LiveData<T>.toSingleEvent(): LiveData<T> {
    val result = SingleLiveEvent<T>()
    result.addSource(this) {
        result.value = it
    }
    return result
}
