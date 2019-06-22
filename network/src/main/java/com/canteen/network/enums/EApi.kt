package com.canteen.network.enums

/**
 * Created by Amr Salah on 5/27/2019.
 */
enum class EApi(val id: Int) {
    GET_CATEGORIES(1),
    ADD_FAV(2),
    REMOVE_FAV(3);

    companion object {
        private val map = EApi.values().associateBy(EApi::id)
        fun fromInt(type: Int) = map[type]
    }
}