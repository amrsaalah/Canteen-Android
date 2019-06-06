package com.canteen.tasks

import android.util.Log
import androidx.work.Constraints
import androidx.work.NetworkType
import androidx.work.OneTimeWorkRequest
import androidx.work.WorkManager
import com.canteen.tasks.workers.TestWorker
import javax.inject.Inject

/**
 * Created by Amr Salah on 5/21/2019.
 */

class TasksHandler @Inject constructor(private val workManager: WorkManager) {

    companion object {
        private const val TAG = "TasksHandler"
    }


    fun startWorker() {
        Log.d(TAG, "startWorker: ")
        val request = OneTimeWorkRequest.Builder(TestWorker::class.java)
            .setConstraints(Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED).build())
            .build()
        workManager.enqueue(request)
    }

}