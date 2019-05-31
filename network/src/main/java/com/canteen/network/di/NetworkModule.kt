package com.canteen.network.di

import androidx.annotation.NonNull
import com.canteen.base.Session
import com.canteen.base.di.scopes.AppScope
import com.canteen.base.utils.Constants
import com.canteen.network.BuildConfig
import com.canteen.network.interceptors.AuthInterceptor
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Created by Amr Salah on 5/22/2019.
 */
@Module(includes = [RemoteDataSourceModule::class, ServiceModule::class])
class NetworkModule {

    @AppScope
    @Provides
    fun provideOkHttpInterceptors(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    }

    @AppScope
    @Provides
    fun okHttpClient(
        httpLoggingInterceptor: HttpLoggingInterceptor,
        authInterceptor: AuthInterceptor
    ): OkHttpClient {

        return OkHttpClient.Builder()
            .addInterceptor(authInterceptor)
            .addInterceptor(httpLoggingInterceptor)
            .connectTimeout(Constants.CONNECT_TIMEOUT, TimeUnit.SECONDS)
            .writeTimeout(Constants.WRITE_TIMEOUT, TimeUnit.SECONDS)
            .readTimeout(Constants.READ_TIMEOUT, TimeUnit.SECONDS)
            .build()
    }


    @AppScope
    @Provides
    fun provideGsonFactory(): Gson {
        return GsonBuilder()
            .setDateFormat("yyyy-MM-dd HH:mm:ss")
            .create()
    }

    @AppScope
    @Provides
    fun provideRetrofitClient(@NonNull okHttpClient: OkHttpClient, gson: Gson): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.API_BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create(gson)) // Serialize Objects
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build()
    }


    @AppScope
    @Provides
    fun provideAuthInterceptor(session: Session): AuthInterceptor {
        return AuthInterceptor(session)
    }
}
