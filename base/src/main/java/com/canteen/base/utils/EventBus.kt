package com.canteen.base.utils

import com.canteen.base.di.scopes.AppScope
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.channels.*
import kotlinx.coroutines.launch
import javax.inject.Inject


/**
 * Created by Amr Salah on 5/27/2019.
 */

@AppScope
class EventBus @Inject constructor() {
    val bus: BroadcastChannel<Any> = ConflatedBroadcastChannel()

    fun send(o: Any) {
        GlobalScope.launch {
            bus.send(o)
        }
    }

    inline fun <reified T> asChannel(): ReceiveChannel<T> {
        return bus.openSubscription().filter { it is T }.map { it as T }
    }
}