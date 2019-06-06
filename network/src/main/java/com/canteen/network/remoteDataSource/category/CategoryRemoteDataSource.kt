package com.canteen.network.remoteDataSource.category

import com.canteen.base.response.Resource
import com.canteen.network.api.CategoryResponse
import com.canteen.network.remoteDataSource.BaseRemoteDataSource
import com.canteen.network.services.CategoryService
import javax.inject.Inject

/**
 * Created by Amr Salah on 5/27/2019.
 */
class CategoryRemoteDataSource @Inject constructor(private val categoryService: CategoryService) :
    BaseRemoteDataSource(), ICategoryRemoteDataSource {

    override suspend fun getAllCategories(): Resource<List<CategoryResponse>> {
        return getResource { categoryService.getAllCategories() }
    }


}