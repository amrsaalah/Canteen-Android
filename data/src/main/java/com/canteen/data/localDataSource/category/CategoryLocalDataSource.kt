package com.canteen.data.localDataSource.category

import com.canteen.data.daos.CategoryDao
import com.canteen.data.entities.Category
import javax.inject.Inject

/**
 * Created by Amr Salah on 5/19/2019.
 */
class CategoryLocalDataSource @Inject constructor(private val categoryDao: CategoryDao) : ICategoryLocalDataSource {


    override suspend fun getAllCategories(): List<Category> {
        return categoryDao.getCategories()
    }

    override suspend fun insert(entity: Category): Long {
        return categoryDao.insert(entity)
    }

    override suspend fun insertAll(entities: List<Category>) {
        categoryDao.deleteAll()
        return categoryDao.insertAll(entities)
    }

    override suspend fun update(entity: Category) {
        return categoryDao.update(entity)
    }

    override suspend fun delete(entity: Category): Int {
        return categoryDao.delete(entity)
    }

}