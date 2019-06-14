package com.canteen.base.utils

import android.content.Context
import androidx.annotation.StringRes
import androidx.core.util.Preconditions
import com.canteen.base.di.scopes.AppScope
import javax.inject.Inject

/**
 * Created by Amr Salah on 6/14/2019.
 */
@AppScope
class ResourceProvider @Inject constructor(context: Context) {


    private val mContext: Context = Preconditions.checkNotNull(context, "context cannot be null")


    fun getString(@StringRes id: Int): String {
        return mContext.getString(id)
    }


    fun getString(@StringRes id: Int, vararg formatArgs: Any): String {
        return mContext.getString(id, *formatArgs)
    }
}
