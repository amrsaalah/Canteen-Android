package com.canteen.base

import androidx.recyclerview.widget.ListAdapter


/**
 * Created by Amr Salah on 6/6/2019.
 */
abstract class BaseListAdapter<T> : ListAdapter<T, BaseHolder<T>>(BaseDiffUtilCallback<T>()) {

    var items: List<T> = listOf()

    override fun submitList(list: List<T>?) {
        if (list != null)
            this.items = list
        super.submitList(list)
    }


    override fun onBindViewHolder(holder: BaseHolder<T>, position: Int) {
        holder.bind(getItem(position))
    }


}