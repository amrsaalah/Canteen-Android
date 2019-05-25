package com.canteen.presenters.di

import com.canteen.presenters.login.ILoginPresenter
import com.canteen.presenters.login.LoginPresenter
import dagger.Binds
import dagger.Module

/**
 * Created by Amr Salah on 5/25/2019.
 */
@Module
abstract class PresenterModule {

    @Binds
    abstract fun bindLoginPresenter(loginPresenter: LoginPresenter): ILoginPresenter
}