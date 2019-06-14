package com.canteen.network.api

import com.google.gson.annotations.SerializedName

/**
 * Created by Amr Salah on 6/14/2019.
 */
data class UserResponse(
    @SerializedName("UserId") val userId: String,
    @SerializedName("RoleId") val roleId: Int,
    @SerializedName("FullName") val name: String,
    @SerializedName("UserEmail") val email: String
)