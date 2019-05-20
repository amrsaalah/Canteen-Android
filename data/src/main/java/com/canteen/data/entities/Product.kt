package com.canteen.data.entities

import androidx.room.*
import java.util.*

/**
 * Created by Amr Salah on 5/19/2019.
 */
@Entity(
    tableName = "products",
    indices = [
        Index(value = ["categoryId"])
    ],
    foreignKeys = [ForeignKey(
        entity = Category::class,
        parentColumns = arrayOf("id"),
        childColumns = arrayOf("categoryId"),
        onUpdate = ForeignKey.CASCADE,
        onDelete = ForeignKey.CASCADE
    )]
)
data class Product(
    @ColumnInfo(name = "categoryId") val categoryId: Int = 0,
    @ColumnInfo(name = "name") val name: String,
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") override val id: Int = 0,
    @ColumnInfo(name = "createdAt") val createdAt: Date = Date(),
    @ColumnInfo(name = "updatedAt") val updatedAt: Date? = null,
    @ColumnInfo(name = "deletedAt") val deletedAt: Date? = null
) : BaseEntity