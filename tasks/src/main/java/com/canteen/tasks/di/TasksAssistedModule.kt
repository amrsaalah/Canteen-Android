package com.canteen.tasks.di

import com.squareup.inject.assisted.dagger2.AssistedModule
import dagger.Module

/**
 * Created by Amr Salah on 5/21/2019.
 */
@Module(includes = [AssistedInject_TasksAssistedModule::class])
@AssistedModule
interface TasksAssistedModule