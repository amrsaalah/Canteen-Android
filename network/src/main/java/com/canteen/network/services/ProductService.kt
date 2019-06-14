package com.canteen.network.services

import com.canteen.network.api.ProductFilterRequest
import com.canteen.network.api.ProductFilteredListResponse
import com.canteen.network.api.ProductResponse
import retrofit2.Response

/**
 * Created by Amr Salah on 5/31/2019.
 */
interface ProductService {

    suspend fun getProductsFilteredList(request: ProductFilterRequest): Response<ProductFilteredListResponse>
    suspend fun getAllProducts(): List<ProductResponse>

}