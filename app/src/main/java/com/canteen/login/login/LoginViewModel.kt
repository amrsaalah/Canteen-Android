package com.canteen.login.login

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.canteen.base.BaseViewModel
import javax.inject.Inject

/**
 * Created by Amr Salah on 5/24/2019.
 */
class LoginViewModel @Inject constructor() : BaseViewModel(), ILoginViewModel {

    companion object {
        private const val TAG = "LoginViewModel"
    }

    override val email: MutableLiveData<String> = MutableLiveData()
    override val password: MutableLiveData<String> = MutableLiveData()


    override fun login() {
        Log.d(TAG, "login: ")
    }

    override fun forgotPasswordTextClicked() {
        Log.d(TAG, "forgotPasswordTextClicked: ")
    }

}