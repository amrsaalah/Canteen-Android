package com.canteen.network.remoteDataSource.user

import com.canteen.base.response.Resource
import com.canteen.network.api.LoginRequest
import com.canteen.network.api.LoginResponse
import com.canteen.network.api.UserResponse

/**
 * Created by Amr Salah on 5/25/2019.
 */
interface IUserRemoteDataSource {
    suspend fun login(request: LoginRequest): Resource<LoginResponse>

    suspend fun getCurrentUser(): Resource<UserResponse>
}