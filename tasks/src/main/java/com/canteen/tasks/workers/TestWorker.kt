package com.canteen.tasks.workers

import android.content.Context
import android.util.Log
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.canteen.tasks.di.ChildWorkerFactory
import com.squareup.inject.assisted.Assisted
import com.squareup.inject.assisted.AssistedInject

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
        Log.d(TAG, "doWork: ")
        return Result.success()
    }


    @AssistedInject.Factory
    interface Factory : ChildWorkerFactory

}