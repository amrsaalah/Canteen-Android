package com.canteen.network.interceptors

import com.canteen.base.Session
import okhttp3.Interceptor
import okhttp3.Response
import timber.log.Timber
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

        Timber.d(session.currentUser.toString())

        request = request.newBuilder()
            .addHeader("Authorization", "Bearer ${session.currentUser?.token}")
            .build()
        return chain.proceed(request)
    }
}
