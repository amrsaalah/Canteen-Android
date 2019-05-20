package com.canteen.tasks.di

import android.content.Context
import androidx.work.ListenableWorker
import androidx.work.WorkerParameters

/**
 * Created by Amr Salah on 5/20/2019.
 */
interface ChildWorkerFactory {
    fun create(context: Context, params: WorkerParameters): ListenableWorker
}