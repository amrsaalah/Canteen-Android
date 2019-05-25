package com.canteen.network.api

/**
 * Created by Amr Salah on 5/25/2019.
 */
data class LoginRequest(val username: String, val password: String)

data class LoginResponse(val message: String)