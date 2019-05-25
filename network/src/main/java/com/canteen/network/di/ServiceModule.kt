package com.canteen.network.di

import com.canteen.base.di.scopes.AppScope
import com.canteen.network.services.UserService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

/**
 * Created by Amr Salah on 5/25/2019.
 */
@Module
class ServiceModule {
    @AppScope
    @Provides
    fun provideUserService(retrofit: Retrofit) = retrofit.create(UserService::class.java)
}