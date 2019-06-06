package com.canteen.network.services

import com.canteen.network.api.CategoryResponse
import retrofit2.Response
import retrofit2.http.GET

/**
 * Created by Amr Salah on 5/31/2019.
 */
interface CategoryService {

    @GET("categories/getcategories")
    suspend fun getAllCategories(): Response<List<CategoryResponse>>
}