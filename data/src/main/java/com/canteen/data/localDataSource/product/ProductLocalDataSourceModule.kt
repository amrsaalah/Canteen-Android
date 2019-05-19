package com.canteen.data.localDataSource.product

import dagger.Binds
import dagger.Module

/**
 * Created by Amr Salah on 5/19/2019.
 */

@Module
abstract class ProductLocalDataSourceModule {

    @Binds
    abstract fun bind(source: ProductLocalDataSource): IProductLocalDataSource
}