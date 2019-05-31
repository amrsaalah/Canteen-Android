package com.canteen.network.remoteDataSource.category

import com.canteen.network.api.CategoryResponse
import com.canteen.network.services.CategoryService
import javax.inject.Inject

/**
 * Created by Amr Salah on 5/27/2019.
 */
class CategoryRemoteDataSource @Inject constructor(categoryService: CategoryService) :
    ICategoryRemoteDataSource {

    override suspend fun getAllCategories(): CategoryResponse {
        TODO()
    }


}