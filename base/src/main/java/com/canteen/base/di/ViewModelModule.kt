package com.canteen.base.di

import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module

/**
 * Created by Amr Salah on 5/24/2019.
 */
@Module
abstract class ViewModelModule {


    @Binds
    abstract fun bindViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory
}