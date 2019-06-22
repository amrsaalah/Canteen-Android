package com.canteen.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

/**
 * Created by Amr Salah on 5/27/2019.
 */
@Entity(tableName = "entries")
data class Entry(
    @ColumnInfo(name = "api") val api: Int,
    @ColumnInfo(name = "request") val request: String,
    @ColumnInfo(name = "status") val status: Int,
    @ColumnInfo(name = "queryParams") val queryParams: String,
    @ColumnInfo(name = "createdAt") val createdAt: Date = Date(),
    @ColumnInfo(name = "updatedAt") val updatedAt: Date? = null,
    @ColumnInfo(name = "deletedAt") val deletedAt: Date? = null,
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") override val id: Int = 0
) : BaseEntity