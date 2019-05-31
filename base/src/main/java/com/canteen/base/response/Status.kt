package com.canteen.base.response

/**
 * Created by Amr Salah on 11/26/2018.
 */
enum class Status {
    SUCCESS,
    ERROR,
    LOADING;

    fun isSuccessful() = this == SUCCESS

    fun isLoading() = this == LOADING

    fun isError() = this == ERROR
}