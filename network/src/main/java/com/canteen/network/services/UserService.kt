package com.canteen.network.services

import com.canteen.network.api.LoginRequest
import com.canteen.network.api.LoginResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

/**
 * Created by Amr Salah on 5/25/2019.
 */
interface UserService {

    @POST("authenticate")
    suspend fun login(@Body request: LoginRequest): Response<LoginResponse>
}