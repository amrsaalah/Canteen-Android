package com.canteen.dashboard.home

import com.canteen.base.di.scopes.FragmentScope
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by Amr Salah on 5/24/2019.
 */
@Module
abstract class HomeModule {


    @FragmentScope
    @ContributesAndroidInjector()
    abstract fun homeFragment(): HomeFragment
}