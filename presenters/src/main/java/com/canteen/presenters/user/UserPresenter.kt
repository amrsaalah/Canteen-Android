package com.canteen.presenters.user

import com.canteen.repositories.user.IUserRepository
import timber.log.Timber
import javax.inject.Inject

/**
 * Created by Amr Salah on 5/25/2019.
 */


class UserPresenter @Inject constructor(private val userRepository: IUserRepository) :
    IUserPresenter {

    companion object {
        private const val TAG = "UserPresenter"
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
        val response = userRepository.login(email, password)
        Timber.d(response.toString())
    }
}