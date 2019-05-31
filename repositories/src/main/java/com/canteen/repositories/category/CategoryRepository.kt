package com.canteen.repositories.category

import com.canteen.base.utils.EventBus
import com.canteen.data.entities.Category
import com.canteen.data.localDataSource.category.ICategoryLocalDataSource
import com.canteen.data.localDataSource.entry.IEntryLocalDataSource
import com.canteen.network.remoteDataSource.category.ICategoryRemoteDataSource
import com.canteen.repositories.BaseRepository
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

    override suspend fun getAllCategories(): List<Category> {
        TODO()
    }
}