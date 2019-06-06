package com.canteen.network.extensions

import com.canteen.base.response.ErrorResponse
import com.canteen.base.response.Resource
import com.google.gson.Gson
import retrofit2.Response
import timber.log.Timber


/**
 * Created by Amr Salah on 6/1/2019.
 */


fun <ResultType> Response<ResultType>.toResource(): Resource<ResultType> {

    var resource = Resource.loading<ResultType>()
    val gson by lazy { Gson() }


    Timber.d("$isSuccessful")

    if (isSuccessful && body() != null) {
        resource = Resource.success(body()!!)
    } else if (errorBody() != null) {
        resource = try {
            val error: ErrorResponse =
                gson.fromJson(errorBody()!!.string(), ErrorResponse::class.java)
            Resource.error(error)
        } catch (e: Exception) {
            Timber.d("$e")
            Resource.error(message = message())
        }
    }

    return resource
}