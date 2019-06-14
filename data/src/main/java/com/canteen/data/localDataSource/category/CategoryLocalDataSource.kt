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
        val dbCategories = categoryDao.getCategories()

        val sum = dbCategories + entities

        val group = sum.groupBy { it.remoteId }
            .filter { it.value.size == 1 }
            .flatMap { it.value }

        val toBeUpdatedCategories = entities - group


        toBeUpdatedCategories.forEach { remoteCategory ->
            val dbCategory = dbCategories.first {
                it.remoteId == remoteCategory.remoteId
            }
            val update = Category(
                remoteCategory.name,
                dbCategory.id,
                remoteCategory.imgUrl,
                remoteCategory.remoteId
            )
            categoryDao.update(update)
        }

        group.forEach {
            if (dbCategories.contains(it)) {
                categoryDao.delete(it)
            } else {
                categoryDao.insert(it)
            }
        }

    }

    override suspend fun update(entity: Category) {
        return categoryDao.update(entity)
    }

    override suspend fun delete(entity: Category): Int {
        return categoryDao.delete(entity)
    }

}