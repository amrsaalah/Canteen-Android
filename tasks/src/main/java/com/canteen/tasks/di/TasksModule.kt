package com.canteen.tasks.di

import androidx.work.WorkManager
import com.canteen.base.di.scopes.AppScope
import dagger.Module
import dagger.Provides

/**
 * Created by Amr Salah on 5/21/2019.
 */
@Module(includes = [WorkersModule::class, TasksAssistedModule::class])
class TasksModule {

    @Provides
    @AppScope
    fun provideWorkManager(): WorkManager = WorkManager.getInstance()
}