package com.canteen.tasks.workers

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.canteen.base.response.Status
import com.canteen.data.localDataSource.entry.EntryLocalDataSource
import com.canteen.network.enums.EApi
import com.canteen.network.enums.EApi.*
import com.canteen.repositories.product.IProductRepository
import com.canteen.repositories.user.UserRepository
import com.canteen.tasks.di.ChildWorkerFactory
import com.squareup.inject.assisted.Assisted
import com.squareup.inject.assisted.AssistedInject
import timber.log.Timber

/**
 * Created by Amr Salah on 6/22/2019.
 */
class SyncQueueWorker @AssistedInject constructor(
    @Assisted params: WorkerParameters,
    @Assisted context: Context,
    private val entryLocalDataSource: EntryLocalDataSource,
    private val productRepository: IProductRepository,
    private val userRepository: UserRepository
) : CoroutineWorker(context, params) {

    companion object {
        const val TAG = "SyncQueueWorker"
    }

    override suspend fun doWork(): Result {
        Timber.d("do sync queue work")

        val entries = entryLocalDataSource.getEntriesByStatus(Status.ERROR.ordinal)
        Timber.d(entries.toString())

        for (entry in entries) {
            when (EApi.fromInt(entry.api)) {
                GET_CATEGORIES -> {
                }

                ADD_FAV -> {
                    productRepository.syncAddProductToFavorite(entry.id, entry.queryParams)
                }
                REMOVE_FAV -> {
                    productRepository.syncRemoteProductFromFavorite(entry.id, entry.queryParams)
                }
            }
        }

        Timber.d("result success")
        return Result.success()
    }


    @AssistedInject.Factory
    interface Factory : ChildWorkerFactory

}