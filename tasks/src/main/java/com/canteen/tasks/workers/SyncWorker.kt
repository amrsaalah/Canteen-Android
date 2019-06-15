package com.canteen.tasks.workers

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.canteen.repositories.category.CategoryRepository
import com.canteen.repositories.product.ProductRepository
import com.canteen.tasks.di.ChildWorkerFactory
import com.squareup.inject.assisted.Assisted
import com.squareup.inject.assisted.AssistedInject
import timber.log.Timber

/**
 * Created by Amr Salah on 6/15/2019.
 */
class SyncWorker @AssistedInject constructor(
    @Assisted params: WorkerParameters,
    @Assisted context: Context,
    private val categoryRepository: CategoryRepository,
    private val productRepository: ProductRepository
) : CoroutineWorker(context, params) {

    companion object {
        const val TAG = "SyncWorker"
    }

    override suspend fun doWork(): Result {

        categoryRepository.syncCategories()
        productRepository.syncProducts()


        Timber.d("do work sync")

        return Result.success()
    }


    @AssistedInject.Factory
    interface Factory : ChildWorkerFactory

}