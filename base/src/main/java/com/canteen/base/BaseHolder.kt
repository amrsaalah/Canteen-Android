package com.canteen.base

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

/**
 * Created by Amr Salah on 6/6/2019.
 */
abstract class BaseHolder<T>(binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root) {
    abstract fun bind(item: T)
}