package com.canteen.tasks.workers

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.canteen.tasks.di.ChildWorkerFactory
import com.squareup.inject.assisted.Assisted
import com.squareup.inject.assisted.AssistedInject
import timber.log.Timber

/**
 * Created by Amr Salah on 5/20/2019.
 */


class TestWorker @AssistedInject constructor(
    @Assisted params: WorkerParameters,
    @Assisted context: Context
) : CoroutineWorker(context, params) {

    companion object {
        private const val TAG = "TestWorker"
    }


    override suspend fun doWork(): Result {
        Timber.d("do work test worker")
        return Result.success()
    }


    @AssistedInject.Factory
    interface Factory : ChildWorkerFactory

}