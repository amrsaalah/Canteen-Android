package com.canteen.network.di

import com.canteen.network.remoteDataSource.category.CategoryRemoteDataSource
import com.canteen.network.remoteDataSource.category.ICategoryRemoteDataSource
import com.canteen.network.remoteDataSource.product.IProductRemoteDataSource
import com.canteen.network.remoteDataSource.product.ProductRemoteDataSource
import com.canteen.network.remoteDataSource.user.IUserRemoteDataSource
import com.canteen.network.remoteDataSource.user.UserRemoteDataSource
import dagger.Binds
import dagger.Module

/**
 * Created by Amr Salah on 5/25/2019.
 */
@Module
abstract class RemoteDataSourceModule {

    @Binds
    abstract fun bindUserRemote(userRemoteDataSource: UserRemoteDataSource): IUserRemoteDataSource

    @Binds
    abstract fun bindCategoryRemote(categoryRemoteDataSource: CategoryRemoteDataSource): ICategoryRemoteDataSource


    @Binds
    abstract fun bindProductRemote(productRemoteDataSource: ProductRemoteDataSource): IProductRemoteDataSource
}