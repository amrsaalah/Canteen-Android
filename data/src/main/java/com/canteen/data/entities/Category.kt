package com.canteen.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import java.util.*

/**
 * Created by Amr Salah on 5/19/2019.
 */

@Entity(
    tableName = "categories",
    indices = [
        Index(value = ["remoteId"], unique = true)
    ]
)
data class Category(
    @ColumnInfo(name = "name") val name: String,
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") override val id: Int = 0,
    @ColumnInfo(name = "imgUrl") val imgUrl: String? = null,
    @ColumnInfo(name = "remoteId") val remoteId: String? = null,
    @ColumnInfo(name = "createdAt") val createdAt: Date = Date(),
    @ColumnInfo(name = "updatedAt") val updatedAt: Date? = null,
    @ColumnInfo(name = "deletedAt") val deletedAt: Date? = null
) : BaseEntity