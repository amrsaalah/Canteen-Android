package com.canteen.base

/**
 * Created by Amr Salah on 5/27/2019.
 */
data class User(var name: String, var token: String, var isVerified: Boolean)

data class UpdateUser(
    val name: String? = null,
    val token: String? = null,
    val isVerified: Boolean? = null
)
