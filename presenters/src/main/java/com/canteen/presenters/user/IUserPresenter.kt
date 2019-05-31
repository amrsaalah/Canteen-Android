package com.canteen.presenters.user

/**
 * Created by Amr Salah on 5/25/2019.
 */
interface IUserPresenter {

    fun checkLoginValidation(email: String?, password: String?): List<ValidationError>
    suspend fun attemptLogin(email: String, password: String)
}