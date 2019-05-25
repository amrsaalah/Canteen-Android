package com.canteen.repositories.di

import com.canteen.repositories.user.UserModule
import dagger.Module

/**
 * Created by Amr Salah on 5/25/2019.
 */

@Module(includes = [UserModule::class])
class RepositoryModule