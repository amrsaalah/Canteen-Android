package com.canteen.base

import com.canteen.base.di.scopes.AppScope
import javax.inject.Inject

/**
 * Created by Amr Salah on 5/31/2019.
 */
@AppScope
class Session @Inject constructor() {

    var currentUser: User? = null
}