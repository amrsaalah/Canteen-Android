package com.canteen.network.interceptors

import com.canteen.base.BusEvents
import com.canteen.base.utils.EventBus
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

/**
 * Created by Amr Salah on 6/1/2019.
 */
class ErrorInterceptor @Inject constructor(private val eventBus: EventBus) : Interceptor {

    companion object {
        private const val TAG = "ErrorInterceptor"
    }

    override fun intercept(chain: Interceptor.Chain): Response {
        val response = chain.proceed(chain.request())

        if (!response.isSuccessful) {
            when (response.code()) {
                401 -> eventBus.send(BusEvents.ErrorEvent("error message"))
            }
        }

        return response
    }

}