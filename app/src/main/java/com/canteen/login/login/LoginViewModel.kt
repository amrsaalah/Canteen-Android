package com.canteen.login.login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.canteen.R
import com.canteen.base.BaseViewModel
import com.canteen.base.Session
import com.canteen.base.utils.EventBus
import com.canteen.base.utils.ResourceProvider
import com.canteen.base.utils.SingleLiveEvent
import com.canteen.presenters.user.IUserPresenter
import com.canteen.presenters.user.ValidationError
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

/**
 * Created by Amr Salah on 5/24/2019.
 */
class LoginViewModel @Inject constructor(
    private val presenter: IUserPresenter,
    private val eventBus: EventBus,
    private val resourceProvider: ResourceProvider,
    private val session: Session
) : BaseViewModel(eventBus),
    ILoginViewModel {



    override val email: MutableLiveData<String> = MutableLiveData()
    override val password: MutableLiveData<String> = MutableLiveData()
    override val navigateToHome: MutableLiveData<Boolean> = MutableLiveData()
    override val validationError: SingleLiveEvent<ValidationError> = SingleLiveEvent()

    init {
        Timber.d(session.currentUser.toString())
        if (session.currentUser != null) {
            navigateToHome.value = true
        }
    }

    override fun login() {

        validationError.value = null

        val errors = presenter.checkLoginValidation(email.value, password.value)
        if (errors.isEmpty()) {
            viewModelScope.launch {
                val isSuccess = presenter.attemptLogin(email.value!!, password.value!!)
                if (isSuccess) {
                    navigateToHome.value = true
                } else {
                    toastMessage.value = resourceProvider.getString(R.string.invalid_credentials)
                }
            }
        } else {
            for (error in errors) {
                validationError.value = error
            }
        }
    }


    override fun forgotPasswordTextClicked() {

    }

}