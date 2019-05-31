package com.canteen.data.preferences

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.canteen.base.di.scopes.AppScope
import dagger.Module
import dagger.Provides

/**
 * Created by Amr Salah on 5/27/2019.
 */
@Module
class PreferencesModule {

    @AppScope
    @Provides
    fun provideSharedPreferences(context: Application): SharedPreferences {
        return context.getSharedPreferences("Canteen", Context.MODE_PRIVATE)
    }

}