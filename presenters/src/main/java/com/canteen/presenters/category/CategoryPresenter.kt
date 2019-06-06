package com.canteen.presenters.category

import com.canteen.base.BasePresenter
import com.canteen.base.utils.EventBus
import com.canteen.presenters.R
import com.canteen.presenters.displayModels.category.CategoryItem
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


    override suspend fun getCategories(): List<CategoryItem> {
        val categories = categoryRepository.getAllCategories()
        return categories.map { CategoryItem(it.id, it.name, it.imgUrl, R.drawable.placeholder) }
    }

}