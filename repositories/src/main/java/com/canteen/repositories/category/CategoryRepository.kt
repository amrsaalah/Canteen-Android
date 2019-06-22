package com.canteen.repositories.category

import com.canteen.base.response.Status
import com.canteen.base.utils.EventBus
import com.canteen.data.entities.Category
import com.canteen.data.entities.Entry
import com.canteen.data.localDataSource.category.ICategoryLocalDataSource
import com.canteen.data.localDataSource.entry.IEntryLocalDataSource
import com.canteen.network.api.CategoryResponse
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

    override suspend fun getCategoryById(categoryId: Int): Category = withContext(Dispatchers.IO) {
        categoryLocalDataSource.getCategoryById(categoryId)!!
    }

    override suspend fun syncCategories() = withContext(Dispatchers.IO) {
        val response = categoryRemoteDataSource.getAllCategories()
        if (response.status.isSuccessful()) {
            val categories = response.data!!.map {
                mapRemoteToLocal(it)
            }
            categoryLocalDataSource.insertAll(categories)
        }
    }

    override suspend fun getAllCategories(): List<Category> = withContext(Dispatchers.IO) {
        if (shouldFetch(GET_CATEGORIES)) {
            val response = categoryRemoteDataSource.getAllCategories()
            if (response.status.isSuccessful()) {
                Timber.d("${response.data}")
                val categories = response.data!!.map {
                    mapRemoteToLocal(it)
                }

                categoryLocalDataSource.insertAll(categories)
                entryLocalDataSource.insert(
                    Entry(
                        GET_CATEGORIES.id,
                        "",
                        Status.SUCCESS.ordinal,
                        ""
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


    private fun mapRemoteToLocal(response: CategoryResponse): Category {
        return Category(response.categoryName, remoteId = response.categoryId)
    }
}