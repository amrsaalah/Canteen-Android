package com.canteen.base

import androidx.lifecycle.ViewModel

/**
 * Created by Amr Salah on 5/19/2019.
 */
abstract class BaseViewModel<T> : ViewModel(){

    abstract fun handleEvent(event : T)
}