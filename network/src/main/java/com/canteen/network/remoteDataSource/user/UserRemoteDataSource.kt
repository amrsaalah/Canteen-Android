package com.canteen.network.remoteDataSource.user

import com.canteen.network.api.LoginRequest
import com.canteen.network.api.LoginResponse
import com.canteen.network.services.UserService
import javax.inject.Inject

/**
 * Created by Amr Salah on 5/25/2019.
 */
class UserRemoteDataSource @Inject constructor(private val userService: UserService) :
    IUserRemoteDataSource {

    override suspend fun login(request: LoginRequest): LoginResponse {
        return userService.login(request)
    }

}