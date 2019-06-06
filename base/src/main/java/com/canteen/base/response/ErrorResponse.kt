package com.canteen.base.response

import com.google.gson.annotations.SerializedName

/**
 * Created by Amr Salah on 6/1/2019.
 */
data class ErrorResponse(@SerializedName("error_key") val key: String)