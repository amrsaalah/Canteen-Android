package com.canteen.network.di

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
}