package com.canteen.product

import android.content.Context
import com.canteen.base.di.scopes.ActivityScope
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by Amr Salah on 3/17/2020.
 */
@Module
abstract class ProductModule {

    @ActivityScope
    @ContributesAndroidInjector(
        modules = [ProductBinderModule::class]
    )
    abstract fun contributeProductActivity(): ProductActivity
}


@Module
abstract class ProductBinderModule {

    @Binds
    @ActivityScope
    abstract fun bindContext(activity: ProductActivity): Context

}


@Module(includes = [ProductBinderModule::class])
class ProductProviderModule {

    // provide stuff
}