package com.canteen.di

import com.canteen.MainActivity
import com.canteen.base.di.scopes.ActivityScope
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by sarahussien on 2/12/19.
 */
@Module
abstract class ActivitiesModule {

    @ActivityScope
    @ContributesAndroidInjector
    abstract fun contributesSplashActivity(): MainActivity
}