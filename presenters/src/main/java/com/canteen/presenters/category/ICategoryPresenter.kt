package com.canteen.presenters.category

import com.canteen.base.response.Resource
import com.canteen.data.entities.Category

/**
 * Created by Amr Salah on 5/26/2019.
 */
interface ICategoryPresenter {

    suspend fun getCategories(): Resource<List<Category>>
}