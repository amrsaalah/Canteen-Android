package com.canteen.network.remoteDataSource.category

import com.canteen.network.api.CategoryResponse

/**
 * Created by Amr Salah on 5/27/2019.
 */
interface ICategoryRemoteDataSource {

    suspend fun getAllCategories(): CategoryResponse
}