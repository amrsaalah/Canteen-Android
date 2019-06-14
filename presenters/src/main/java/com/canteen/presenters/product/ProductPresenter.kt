package com.canteen.presenters.product

import com.canteen.base.utils.EventBus
import com.canteen.data.entities.Product
import com.canteen.repositories.category.ICategoryRepository
import com.canteen.repositories.data.product.EProductOrder
import com.canteen.repositories.data.product.EProductSort
import com.canteen.repositories.data.product.ProductFilter
import com.canteen.repositories.product.IProductRepository
import com.canteen.repositories.user.IUserRepository
import javax.inject.Inject

/**
 * Created by Amr Salah on 5/31/2019.
 */
class ProductPresenter @Inject constructor(
    private val userRepository: IUserRepository,
    private val productRepository: IProductRepository,
    private val categoryRepository: ICategoryRepository,
    private val eventBus: EventBus
) : IProductPresenter {

    override suspend fun getTopRatedProducts(): List<Product> {
        val productFilter = ProductFilter(1, 5, EProductOrder.RATING, EProductSort.DESC)
        return productRepository.getProductsFilteredList(productFilter)
    }
}