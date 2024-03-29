package com.canteen.network.remoteDataSource.product

import com.canteen.base.response.Resource
import com.canteen.network.api.ProductFilterRequest
import com.canteen.network.api.ProductFilteredListResponse
import com.canteen.network.api.ProductResponse
import com.canteen.network.remoteDataSource.BaseRemoteDataSource
import com.canteen.network.services.ProductService
import javax.inject.Inject

/**
 * Created by Amr Salah on 5/31/2019.
 */
class ProductRemoteDataSource @Inject constructor(private val productService: ProductService) :
    BaseRemoteDataSource(), IProductRemoteDataSource {
    override suspend fun addProductToFavorite(remoteProductId: String): Resource<Any> {
        return getResource { productService.addToProductToFavorite(remoteProductId) }
    }

    override suspend fun removeProductFromFavorite(remoteProductId: String): Resource<Any> {
        return getResource { productService.removeProductFromFavorite(remoteProductId) }
    }

    override suspend fun getProductsFilteredList(request: ProductFilterRequest): Resource<ProductFilteredListResponse> {
        return getResource { productService.getProductsFilteredList(request) }
    }

    override suspend fun getFavoriteProducts(): Resource<List<ProductResponse>> {
        return getResource { productService.getFavoriteProducts() }
    }

    override suspend fun getAllProducts(): Resource<List<ProductResponse>> {
        return getResource { productService.getAllProducts() }
    }
}