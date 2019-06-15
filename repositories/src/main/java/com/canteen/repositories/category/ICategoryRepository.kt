package com.canteen.repositories.category

import com.canteen.data.entities.Category

/**
 * Created by Amr Salah on 5/31/2019.
 */
interface ICategoryRepository {

    suspend fun getAllCategories(): List<Category>
    suspend fun syncCategories()
}