package com.canteen.login.login

import androidx.lifecycle.ViewModel
import com.canteen.base.di.scopes.FragmentScope
import com.canteen.di.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

/**
 * Created by Amr Salah on 5/24/2019.
 */
@Module
abstract class LoginModule {

    @FragmentScope
    @ContributesAndroidInjector()
    abstract fun loginFragment(): LoginFragment

    @Binds
    @IntoMap
    @ViewModelKey(LoginViewModel::class)
    abstract fun bindLoginViewModel(loginViewModel: LoginViewModel): ViewModel

}