package com.canteen.base.di

import com.canteen.base.bindingAdapters.ViewBindingAdapter
import com.canteen.base.di.scopes.AppScope
import dagger.Module
import dagger.Provides

/**
 * Created by Amr Salah on 5/25/2019.
 */
@Module
class BindingAdapterModule {

    @Provides
    @AppScope
    fun provideBidingAdapter(): ViewBindingAdapter {
        return ViewBindingAdapter()
    }
}