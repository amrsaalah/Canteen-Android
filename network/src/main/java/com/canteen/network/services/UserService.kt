package com.canteen.network.services

import com.canteen.network.api.LoginRequest
import com.canteen.network.api.LoginResponse
import retrofit2.http.POST

/**
 * Created by Amr Salah on 5/25/2019.
 */
interface UserService {

    @POST
    suspend fun login(request: LoginRequest): LoginResponse
}