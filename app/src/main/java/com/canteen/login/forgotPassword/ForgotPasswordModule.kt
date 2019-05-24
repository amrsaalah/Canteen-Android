package com.canteen.login.forgotPassword

import com.canteen.base.di.scopes.FragmentScope
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by Amr Salah on 5/24/2019.
 */
@Module
abstract class ForgotPasswordModule {

    @FragmentScope
    @ContributesAndroidInjector()
    abstract fun forgotPasswordFragment(): ForgotPasswordFragment

}