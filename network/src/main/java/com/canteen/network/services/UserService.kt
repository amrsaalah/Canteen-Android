package com.canteen.network.services

import com.canteen.network.api.LoginRequest
import com.canteen.network.api.LoginResponse
import com.canteen.network.api.UserResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

/**
 * Created by Amr Salah on 5/25/2019.
 */
interface UserService {

    @POST("token")
    suspend fun login(@Body request: LoginRequest): Response<LoginResponse>

    @GET("users/currentUser")
    suspend fun getCurrentUser(): Response<UserResponse>
}