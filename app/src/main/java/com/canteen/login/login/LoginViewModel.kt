package com.canteen.login.login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.canteen.base.BaseViewModel
import com.canteen.presenters.user.IUserPresenter
import com.canteen.presenters.user.ValidationError
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by Amr Salah on 5/24/2019.
 */
class LoginViewModel @Inject constructor(private val presenter: IUserPresenter) : BaseViewModel(),
    ILoginViewModel {

    companion object {
        private const val TAG = "LoginViewModel"
    }


    override val email: MutableLiveData<String> = MutableLiveData()
    override val password: MutableLiveData<String> = MutableLiveData()
    override val user: MutableLiveData<String> = MutableLiveData()

    init {
        email.value = "123"
        password.value = "123"
    }

    override fun login() {

        val errors = presenter.checkLoginValidation(email.value, password.value)
        if (errors.isEmpty()) {
            viewModelScope.launch {
                // presenter.attemptLogin(email.value!! , password.value!!)
            }
        } else {
            for (error in errors) {
                when (error) {
                    ValidationError.EMPTY_EMAIL -> toastMessage.value = "wrong email"
                    ValidationError.EMPTY_PASSWORD -> toastMessage.value = "wrong password"
                }
            }
        }
    }


    override fun forgotPasswordTextClicked() {

    }

}