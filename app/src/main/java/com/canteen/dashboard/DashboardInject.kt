package com.canteen.dashboard

import android.content.Context
import com.canteen.base.di.scopes.ActivityScope
import com.canteen.dashboard.favorite.FavoriteModule
import com.canteen.dashboard.home.HomeModule
import com.canteen.dashboard.search.SearchModule
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by Amr Salah on 5/24/2019.
 */
@Module
abstract class DashboardModule {

    @ActivityScope
    @ContributesAndroidInjector(
        modules = [DashboardProviderModule::class, HomeModule::class, FavoriteModule::class,
            SearchModule::class]
    )

    abstract fun dashboardActivity(): DashboardActivity

}


@Module
abstract class DashboardBinderModule {

    @Binds
    @ActivityScope
    abstract fun bindContext(activity: DashboardActivity): Context

}


@Module(includes = [DashboardBinderModule::class])
class DashboardProviderModule {

    // provide stuff
}