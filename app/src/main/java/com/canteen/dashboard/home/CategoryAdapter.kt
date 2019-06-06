package com.canteen.dashboard.home

import android.view.LayoutInflater
import android.view.ViewGroup
import com.canteen.base.BaseHolder
import com.canteen.base.BaseListAdapter
import com.canteen.databinding.ListItemCategoryBinding
import com.canteen.presenters.displayModels.category.CategoryItem

/**
 * Created by Amr Salah on 6/6/2019.
 */
class CategoryAdapter : BaseListAdapter<CategoryItem>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseHolder<CategoryItem> {
        return CategoryHolder(
            ListItemCategoryBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    inner class CategoryHolder(private val binding: ListItemCategoryBinding) :
        BaseHolder<CategoryItem>(binding) {

        override fun bind(item: CategoryItem) {
            binding.category = item
            binding.executePendingBindings()
        }
    }

}