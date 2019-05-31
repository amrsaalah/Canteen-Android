package com.canteen.repositories.di

import com.canteen.repositories.category.CategoryRepository
import com.canteen.repositories.category.ICategoryRepository
import com.canteen.repositories.product.IProductRepository
import com.canteen.repositories.product.ProductRepository
import com.canteen.repositories.user.IUserRepository
import com.canteen.repositories.user.UserRepository
import dagger.Binds
import dagger.Module

/**
 * Created by Amr Salah on 5/25/2019.
 */

@Module
abstract class RepositoryModule {

    @Binds
    abstract fun bindUserRepository(userRepository: UserRepository): IUserRepository

    @Binds
    abstract fun bindCategoryRepository(categoryRepository: CategoryRepository): ICategoryRepository

    @Binds
    abstract fun bindProductRepository(productRepository: ProductRepository): IProductRepository
}