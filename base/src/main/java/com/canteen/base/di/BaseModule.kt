package com.canteen.base.di

import android.app.Application
import android.content.Context
import com.canteen.base.di.scopes.AppScope
import dagger.Binds
import dagger.Module

/**
 * Created by Amr Salah on 5/27/2019.
 */

@Module
abstract class BaseModule {

    @AppScope
    @Binds
    abstract fun provideContext(application: Application): Context
}
