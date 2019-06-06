package com.canteen.repositories.user

import com.canteen.base.UpdateUser
import com.canteen.base.User
import com.canteen.base.response.Resource
import com.canteen.network.api.LoginResponse

/**
 * Created by Amr Salah on 5/25/2019.
 */

interface IUserRepository {

    suspend fun login(username: String, password: String): Resource<LoginResponse>

    fun createUserIfNotExist(user: User)
    fun updateUser(user: UpdateUser)
    fun clearUser()
}