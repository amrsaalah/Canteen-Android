package com.canteen.data.di

import com.canteen.data.localDataSource.category.CategoryLocalDataSource
import com.canteen.data.localDataSource.category.ICategoryLocalDataSource
import com.canteen.data.localDataSource.entry.EntryLocalDataSource
import com.canteen.data.localDataSource.entry.IEntryLocalDataSource
import com.canteen.data.localDataSource.product.IProductLocalDataSource
import com.canteen.data.localDataSource.product.ProductLocalDataSource
import dagger.Binds
import dagger.Module

/**
 * Created by Amr Salah on 5/27/2019.
 */

@Module
abstract class LocalDataSourceModule {

    @Binds
    abstract fun bindCategory(source: CategoryLocalDataSource): ICategoryLocalDataSource

    @Binds
    abstract fun bindProduct(source: ProductLocalDataSource): IProductLocalDataSource


    @Binds
    abstract fun bindEntry(source: EntryLocalDataSource): IEntryLocalDataSource


}