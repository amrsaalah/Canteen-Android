package com.canteen.repositories.user

import dagger.Binds
import dagger.Module

/**
 * Created by Amr Salah on 5/25/2019.
 */
@Module
abstract class UserModule {

    @Binds
    abstract fun bindUserRepository(userRepository: UserRepository): IUserRepository
}
