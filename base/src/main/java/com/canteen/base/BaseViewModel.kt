package com.canteen.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * Created by Amr Salah on 5/19/2019.
 */
abstract class BaseViewModel : ViewModel(), IBaseViewModel {

    val toastMessage: MutableLiveData<String> = MutableLiveData()
}