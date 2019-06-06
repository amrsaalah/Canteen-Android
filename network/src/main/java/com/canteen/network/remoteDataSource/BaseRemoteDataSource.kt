package com.canteen.network.remoteDataSource

import com.canteen.base.response.Resource
import com.canteen.network.extensions.toResource
import kotlinx.coroutines.coroutineScope
import retrofit2.Response

/**
 * Created by Amr Salah on 6/6/2019.
 */
abstract class BaseRemoteDataSource {

    suspend fun <T> getResource(block: suspend () -> Response<T>): Resource<T> = coroutineScope {
        try {
            block.invoke().toResource()
        } catch (e: Exception) {
            Resource.error<T>(message = e.message)
        }
    }
}