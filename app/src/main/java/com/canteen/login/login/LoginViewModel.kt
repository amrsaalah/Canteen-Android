package com.canteen.login.login

import androidx.lifecycle.MutableLiveData
import com.canteen.base.BaseViewModel
import javax.inject.Inject

/**
 * Created by Amr Salah on 5/24/2019.
 */
class LoginViewModel @Inject constructor() : BaseViewModel<LoginEvent>(), ILoginViewModel {

    override val email: MutableLiveData<String> = MutableLiveData()
    override val password: MutableLiveData<String> = MutableLiveData()


    override fun handleEvent(event: LoginEvent) {
        when (event) {
            is LoginEvent.AttemptLogin -> {

            }

            is LoginEvent.ForgotPasswordTextClicked -> {

            }
        }
    }


}