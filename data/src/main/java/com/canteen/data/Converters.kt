package com.canteen.data

import androidx.room.TypeConverter
import java.util.*


/**
 * Created by Amr Salah on 5/20/2019.
 */
class Converters {

    @TypeConverter
    fun fromTimestamp(value: Long?): Date? {
        return if (value == null) null else Date(value)
    }

    @TypeConverter
    fun dateToTimestamp(date: Date?): Long? {
        return (if (date == null) null else date.time)?.toLong()
    }

//    @TypeConverter
//    fun fromFavorites(favorites: List<Favorite>?): String? {
//        if (favorites == null) {
//            return null
//        }
//        val gson = Gson()
//        val type = object : TypeToken<List<Favorite>>() {}.type
//
//        return gson.toJson(favorites, type)
//    }
//
//    @TypeConverter
//    fun toFavorites(value: String?): List<Favorite>? {
//        if (value == null) {
//            return null
//        }
//        val gson = Gson()
//        val type = object : TypeToken<List<Favorite>>() {
//
//        }.type
//        return gson.fromJson<List<Favorite>>(value, type)
//    }

}