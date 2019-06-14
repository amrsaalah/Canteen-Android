package com.canteen.repositories.user

import com.canteen.base.User

/**
 * Created by Amr Salah on 5/25/2019.
 */

interface IUserRepository {

    suspend fun login(username: String, password: String): Boolean
    suspend fun getCurrentUser(): User?

    fun updateUser(user: User)
    fun clearUser()
}