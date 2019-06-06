package com.canteen.base

/**
 * Created by Amr Salah on 6/5/2019.
 */
sealed class BusEvents {

    data class ErrorEvent(val message: String) : BusEvents()

}