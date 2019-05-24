package com.canteen.login.login

import androidx.lifecycle.MutableLiveData

/**
 * Created by Amr Salah on 5/24/2019.
 */

interface ILoginViewModel {
    val email: MutableLiveData<String>
    val password: MutableLiveData<String>
}

sealed class LoginEvent {
    object AttemptLogin : LoginEvent()
    object ForgotPasswordTextClicked : LoginEvent()
}