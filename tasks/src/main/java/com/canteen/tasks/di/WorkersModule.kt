package com.canteen.tasks.di

import com.canteen.tasks.workers.TestWorker
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * Created by Amr Salah on 5/21/2019.
 */
@Module
abstract class WorkersModule {

    @Binds
    @IntoMap
    @WorkerKey(TestWorker::class)
    abstract fun bindTestWorker(factory: TestWorker.Factory): ChildWorkerFactory


}