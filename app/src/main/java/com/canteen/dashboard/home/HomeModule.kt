package com.canteen.dashboard.home

import androidx.lifecycle.ViewModel
import com.canteen.base.di.scopes.FragmentScope
import com.canteen.base.di.scopes.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

/**
 * Created by Amr Salah on 5/24/2019.
 */
@Module
abstract class HomeModule {


    @FragmentScope
    @ContributesAndroidInjector()
    abstract fun homeFragment(): HomeFragment


    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    abstract fun bindLoginViewModel(loginViewModel: HomeViewModel): ViewModel


    @Binds
    abstract fun bindIViewModel(loginViewModel: HomeViewModel): IHomeViewModel
}