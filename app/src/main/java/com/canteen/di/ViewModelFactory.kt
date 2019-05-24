package com.canteen.di

import androidx.annotation.NonNull
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject
import javax.inject.Provider


class ViewModelFactory @Inject
constructor(private val mProviderMap: Map<Class<out ViewModel>, @JvmSuppressWildcards Provider<ViewModel>>) :
    ViewModelProvider.Factory {

    @NonNull
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(@NonNull modelClass: Class<T>): T {
        return mProviderMap.getValue(modelClass).get() as T
    }
}