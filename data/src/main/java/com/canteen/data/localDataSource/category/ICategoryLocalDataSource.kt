package com.canteen.data.localDataSource.category

import com.canteen.data.entities.Category
import com.canteen.data.localDataSource.BaseLocalDataSource

/**
 * Created by Amr Salah on 5/19/2019.
 */
interface ICategoryLocalDataSource : BaseLocalDataSource<Category> {

    suspend fun getAllCategories(): List<Category>
    suspend fun getCategoryById(categoryId: Int): Category?
    suspend fun getCategoryByRemoteId(categoryRemoteId: String): Category?
}