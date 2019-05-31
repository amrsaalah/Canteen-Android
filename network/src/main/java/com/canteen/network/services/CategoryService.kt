package com.canteen.network.services

import com.canteen.network.api.CategoryResponse

/**
 * Created by Amr Salah on 5/31/2019.
 */
interface CategoryService {

    suspend fun getAllCategories(): CategoryResponse
}