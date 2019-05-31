package com.canteen.presenters.di

import com.canteen.presenters.category.CategoryPresenter
import com.canteen.presenters.category.ICategoryPresenter
import com.canteen.presenters.product.IProductPresenter
import com.canteen.presenters.product.ProductPresenter
import com.canteen.presenters.user.IUserPresenter
import com.canteen.presenters.user.UserPresenter
import dagger.Binds
import dagger.Module

/**
 * Created by Amr Salah on 5/25/2019.
 */
@Module
abstract class PresenterModule {

    @Binds
    abstract fun bindUserPresenter(loginPresenter: UserPresenter): IUserPresenter

    @Binds
    abstract fun bindCategoryPresenter(loginPresenter: CategoryPresenter): ICategoryPresenter


    @Binds
    abstract fun bindProductPresenter(productPresenter: ProductPresenter): IProductPresenter
}