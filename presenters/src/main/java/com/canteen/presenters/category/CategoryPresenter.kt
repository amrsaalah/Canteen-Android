package com.canteen.presenters.category

import com.canteen.base.BasePresenter
import com.canteen.base.response.Resource
import com.canteen.base.utils.EventBus
import com.canteen.data.entities.Category
import com.canteen.repositories.category.ICategoryRepository
import com.canteen.repositories.product.IProductRepository
import com.canteen.repositories.user.IUserRepository
import javax.inject.Inject

/**
 * Created by Amr Salah on 5/26/2019.
 */


class CategoryPresenter @Inject constructor(
    private val categoryRepository: ICategoryRepository,
    private val userRepository: IUserRepository,
    private val productRepository: IProductRepository,
    private val eventBus: EventBus
) : BasePresenter(),
    ICategoryPresenter {

    companion object {
        private const val TAG = "CategoryPresenter"
    }

    override suspend fun getCategories(): Resource<List<Category>> {
        TODO()
    }

}