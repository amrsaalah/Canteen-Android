package com.canteen.network.remoteDataSource.product

import com.canteen.base.response.Resource
import com.canteen.network.api.ProductFilterRequest
import com.canteen.network.api.ProductFilteredListResponse
import com.canteen.network.api.ProductResponse

/**
 * Created by Amr Salah on 5/31/2019.
 */

interface IProductRemoteDataSource {

    suspend fun getAllProducts(): Resource<List<ProductResponse>>

    suspend fun getFavoriteProducts(): Resource<List<ProductResponse>>

    suspend fun getProductsFilteredList(request: ProductFilterRequest): Resource<ProductFilteredListResponse>
}