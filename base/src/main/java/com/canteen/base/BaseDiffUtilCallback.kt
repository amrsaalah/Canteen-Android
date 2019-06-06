package com.canteen.base

import android.annotation.SuppressLint
import androidx.recyclerview.widget.DiffUtil

/**
 * Created by Amr Salah on 6/6/2019.
 */

class BaseDiffUtilCallback<T> : DiffUtil.ItemCallback<T>() {

    override fun areItemsTheSame(oldItem: T, newItem: T): Boolean {
        return oldItem == newItem
    }

    @SuppressLint("DiffUtilEquals")
    override fun areContentsTheSame(oldItem: T, newItem: T): Boolean {
        return oldItem == newItem
    }
}