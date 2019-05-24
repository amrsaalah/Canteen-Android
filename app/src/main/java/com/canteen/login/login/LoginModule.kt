package com.canteen.login.login

import com.canteen.base.di.scopes.FragmentScope
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by Amr Salah on 5/24/2019.
 */
@Module
abstract class LoginModule {

    @FragmentScope
    @ContributesAndroidInjector()
    abstract fun loginFragment(): LoginFragment

}