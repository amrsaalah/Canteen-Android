package com.canteen.repositories.category

import com.canteen.base.response.Status
import com.canteen.base.utils.EventBus
import com.canteen.data.entities.Category
import com.canteen.data.entities.Entry
import com.canteen.data.localDataSource.category.ICategoryLocalDataSource
import com.canteen.data.localDataSource.entry.IEntryLocalDataSource
import com.canteen.network.enums.EApi.GET_CATEGORIES
import com.canteen.network.remoteDataSource.category.ICategoryRemoteDataSource
import com.canteen.repositories.BaseRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import timber.log.Timber
import javax.inject.Inject

/**
 * Created by Amr Salah on 5/31/2019.
 */

class CategoryRepository @Inject constructor(
    private val categoryLocalDataSource: ICategoryLocalDataSource,
    private val categoryRemoteDataSource: ICategoryRemoteDataSource,
    private val eventBus: EventBus,
    private val entryLocalDataSource: IEntryLocalDataSource
) : BaseRepository(entryLocalDataSource), ICategoryRepository {

    override suspend fun getAllCategories(): List<Category> = withContext(Dispatchers.IO) {
        if (shouldFetch(GET_CATEGORIES)) {
            val response = categoryRemoteDataSource.getAllCategories()
            if (response.status.isSuccessful()) {
                Timber.d("${response.data}")
                val categories = response.data!!.map {
                    Category(it.categoryName, remoteId = it.categoryId)
                }

                categoryLocalDataSource.insertAll(categories)
                entryLocalDataSource.insert(
                    Entry(
                        GET_CATEGORIES.ordinal,
                        "",
                        Status.SUCCESS.ordinal
                    )
                )
                categoryLocalDataSource.getAllCategories()
            } else {
                categoryLocalDataSource.getAllCategories()
            }
        } else {
            categoryLocalDataSource.getAllCategories()
        }
    }

}