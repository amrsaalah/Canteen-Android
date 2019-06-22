package com.canteen.dashboard.home

import android.view.LayoutInflater
import android.view.ViewGroup
import com.canteen.base.BaseHolder
import com.canteen.base.BaseListAdapter
import com.canteen.databinding.ListItemProductHomeBinding
import com.canteen.presenters.displayModels.product.ProductItem

/**
 * Created by Amr Salah on 6/15/2019.
 */
class ProductAdapter(private val homeViewModel: IHomeViewModel) : BaseListAdapter<ProductItem>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseHolder<ProductItem> {
        return CategoryHolder(
            ListItemProductHomeBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    inner class CategoryHolder(private val binding: ListItemProductHomeBinding) :
        BaseHolder<ProductItem>(binding) {

        override fun bind(item: ProductItem) {
            binding.product = item
            binding.viewModel = homeViewModel
            binding.executePendingBindings()
        }
    }
}