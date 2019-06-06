package com.canteen.base.di

import com.canteen.base.bindingAdapters.ImageViewBindingAdapter
import com.canteen.base.bindingAdapters.TextViewBindingAdapter
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
    fun provideTextBidingAdapter(): TextViewBindingAdapter {
        return TextViewBindingAdapter()
    }

    @Provides
    @AppScope
    fun provideImageBidingAdapter(): ImageViewBindingAdapter {
        return ImageViewBindingAdapter()
    }
}