package com.canteen.presenters.login

import com.canteen.base.BasePresenter
import com.canteen.repositories.user.IUserRepository
import javax.inject.Inject

/**
 * Created by Amr Salah on 5/25/2019.
 */


class LoginPresenter @Inject constructor(private val userRepository: IUserRepository) :
    BasePresenter(), ILoginPresenter {

    companion object {
        private const val TAG = "LoginPresenter"
    }


    override fun checkLoginValidation(email: String?, password: String?): List<ValidationError> {

        val errors: ArrayList<ValidationError> = arrayListOf()
        if (email.isNullOrEmpty()) {
            errors.add(ValidationError.EMPTY_EMAIL)
        }

        if (password.isNullOrEmpty()) {
            errors.add(ValidationError.EMPTY_PASSWORD)
        }

        return errors

    }

    override suspend fun attemptLogin(email: String, password: String) {
        userRepository.login(email, password)
    }
}