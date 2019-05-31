package com.canteen.network.remoteDataSource.product

import com.canteen.network.services.ProductService
import javax.inject.Inject

/**
 * Created by Amr Salah on 5/31/2019.
 */
class ProductRemoteDataSource @Inject constructor(productService: ProductService) :
    IProductRemoteDataSource