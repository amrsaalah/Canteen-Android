package com.canteen.repositories.user

import com.canteen.data.localDataSource.product.IProductLocalDataSource
import com.canteen.network.api.LoginRequest
import com.canteen.network.api.LoginResponse
import com.canteen.network.remoteDataSource.user.IUserRemoteDataSource
import javax.inject.Inject

/**
 * Created by Amr Salah on 5/25/2019.
 */

class UserRepository @Inject constructor(
    private val userRemoteDataSource: IUserRemoteDataSource,
    private val productLocalDataSource: IProductLocalDataSource
) : IUserRepository {

    override suspend fun login(username: String, password: String): LoginResponse {
        return userRemoteDataSource.login(LoginRequest(username, password))
    }

}