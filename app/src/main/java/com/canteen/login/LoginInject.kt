package com.canteen.login

import android.content.Context
import com.canteen.base.di.scopes.ActivityScope
import com.canteen.login.forgotPassword.ForgotPasswordModule
import com.canteen.login.login.LoginModule
import com.canteen.login.register.RegisterModule
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by Amr Salah on 5/24/2019.
 */

@Module
abstract class LoginModule {

    @ActivityScope
    @ContributesAndroidInjector(
        modules = [LoginProviderModule::class, LoginModule::class,
            RegisterModule::class, ForgotPasswordModule::class]
    )
    abstract fun contributesLoginActivity(): LoginActivity
}


@Module
abstract class LoginBinderModule {

    @Binds
    @ActivityScope
    abstract fun bindContext(activity: LoginActivity): Context

}


@Module(includes = [LoginBinderModule::class])
class LoginProviderModule {

    // provide stuff
}