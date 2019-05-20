package com.canteen.tasks

import androidx.work.WorkManager
import javax.inject.Inject

/**
 * Created by Amr Salah on 5/21/2019.
 */

class TasksHandler @Inject constructor(private val workManager: WorkManager) {

    companion object {
        private const val TAG = "TasksHandler"
    }

    fun startWorker() {

    }

}