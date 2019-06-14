package com.canteen.base.extensions

import android.view.View

/**
 * Created by Amr Salah on 6/7/2019.
 */

fun View.show() {
    this.visibility = View.VISIBLE
}

fun View.invisible() {
    this.visibility = View.INVISIBLE
}

fun View.hide() {
    this.visibility = View.GONE
}

