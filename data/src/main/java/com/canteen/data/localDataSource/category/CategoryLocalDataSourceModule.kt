package com.canteen.data.localDataSource.category

import dagger.Binds
import dagger.Module

/**
 * Created by Amr Salah on 5/19/2019.
 */

@Module
abstract class CategoryLocalDataSourceModule {

    @Binds
    abstract fun bind(source: CategoryLocalDataSource): ICategoryLocalDataSource
}