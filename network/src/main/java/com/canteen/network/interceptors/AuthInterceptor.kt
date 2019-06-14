package com.canteen.network.interceptors

import com.canteen.base.Session
import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException
import javax.inject.Inject

/**
 * Created by Amr Salah on 5/22/2019.
 */
class AuthInterceptor @Inject constructor(private val session: Session) : Interceptor {

    companion object {
        private const val TAG = "AuthInterceptor"
    }

    init {

    }

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()


        val token =
            "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJSb2xlSWQiOiIxIiwiVXNlcklkIjoiMSIsIm5iZiI6MTU1OTg0MDEyOSwiZXhwIjoxNTY1MDI0MTI5LCJpc3MiOiJDYW50ZWVuQVBJIiwiYXVkIjoiQ2FudGVlbkFQSUNsaWVudHMifQ.i_8CXsN7bE6GPr-fzxk8wd0CcmJpkEX65RsKbFs8OrA"

        request = request.newBuilder()
            .addHeader("Authorization", "Bearer ${session.currentUser?.token}")
            .build()
        return chain.proceed(request)
    }
}
