package com.canteen.login.login

import androidx.lifecycle.MutableLiveData
import com.canteen.base.utils.SingleLiveEvent
import com.canteen.presenters.user.ValidationError

/**
 * Created by Amr Salah on 5/24/2019.
 */

interface ILoginViewModel {
    val email: MutableLiveData<String>
    val password: MutableLiveData<String>
    val navigateToHome: MutableLiveData<Boolean>
    val validationError: SingleLiveEvent<ValidationError>

    fun login()
    fun forgotPasswordTextClicked()
}




