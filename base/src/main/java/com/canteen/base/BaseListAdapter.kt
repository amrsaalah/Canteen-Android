package com.canteen.base

import androidx.recyclerview.widget.ListAdapter


/**
 * Created by Amr Salah on 6/6/2019.
 */
abstract class BaseListAdapter<T> : ListAdapter<T, BaseHolder<T>>(BaseDiffUtilCallback<T>()) {

    override fun onBindViewHolder(holder: BaseHolder<T>, position: Int) {
        holder.bind(getItem(position))
    }

}