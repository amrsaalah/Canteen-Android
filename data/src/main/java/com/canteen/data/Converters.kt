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
}