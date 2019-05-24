package com.canteen.network.interceptors

import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException

/**
 * Created by Amr Salah on 5/22/2019.
 */
class AuthInterceptor : Interceptor {

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        request = request.newBuilder()
            .addHeader("Authorization", "")
            .build()
        return chain.proceed(request)
    }
}
