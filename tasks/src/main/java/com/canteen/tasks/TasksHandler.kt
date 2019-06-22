package com.canteen.tasks

import androidx.work.*
import com.canteen.base.Session
import com.canteen.repositories.ITasksHandler
import com.canteen.tasks.workers.SyncQueueWorker
import com.canteen.tasks.workers.SyncWorker
import com.canteen.tasks.workers.TestWorker
import timber.log.Timber
import java.util.concurrent.TimeUnit
import javax.inject.Inject

/**
 * Created by Amr Salah on 5/21/2019.
 */

class TasksHandler @Inject constructor(
    private val workManager: WorkManager,
    private val session: Session
) : ITasksHandler {

    override suspend fun startSyncQueue() {
        Timber.d("sync queue started")
        val request = OneTimeWorkRequest.Builder(SyncQueueWorker::class.java)
            .setConstraints(Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED).build())
            .build()

        workManager.enqueueUniqueWork(SyncQueueWorker.TAG, ExistingWorkPolicy.REPLACE, request)
    }


    fun startWorker() {
        val request = OneTimeWorkRequest.Builder(TestWorker::class.java)
            .setConstraints(Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED).build())
            .build()
        workManager.enqueue(request)
    }


    fun startSyncWorker() {
        if (session.currentUser != null) {
            val periodicRequest =
                PeriodicWorkRequest.Builder(SyncWorker::class.java, 1, TimeUnit.DAYS)
                    .setConstraints(
                        Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED)
                            .build()
                    )
                    .build()

            workManager.enqueueUniquePeriodicWork(
                SyncWorker.TAG,
                ExistingPeriodicWorkPolicy.REPLACE,
                periodicRequest
            )
        }

    }
}