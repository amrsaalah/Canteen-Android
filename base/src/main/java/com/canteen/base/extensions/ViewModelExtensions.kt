package com.canteen.base.extensions

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders

/**
 * Created by Amr Salah on 5/24/2019.
 */


inline fun <reified T : ViewModel> getViewModel(
    context: Fragment,
    factory: ViewModelProvider.Factory
): T {
    return ViewModelProviders.of(context, factory)[T::class.java]
}


inline fun <reified T : ViewModel> getViewModel(
    context: FragmentActivity,
    factory: ViewModelProvider.Factory
): T {
    return ViewModelProviders.of(context, factory)[T::class.java]
}