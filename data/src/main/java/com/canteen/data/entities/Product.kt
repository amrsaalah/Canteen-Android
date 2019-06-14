package com.canteen.data.entities

import androidx.room.*
import java.util.*

/**
 * Created by Amr Salah on 5/19/2019.
 */
@Entity(
    tableName = "products",
    indices = [
        Index(value = ["categoryId"]),
        Index(value = ["remoteId"], unique = true)
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
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "description") val description: String,
    @ColumnInfo(name = "categoryId") val categoryId: Int,
    @ColumnInfo(name = "price") val price: Double,
    @ColumnInfo(name = "rating") val rating: Double,
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") override val id: Int = 0,
    @ColumnInfo(name = "remoteId") val remoteId: String? = null,
    @ColumnInfo(name = "remoteCategoryId") val remoteCategoryId: String? = null,
    @ColumnInfo(name = "imageUrl") val imageUrl: String? = null,
    @ColumnInfo(name = "createdAt") val createdAt: Date = Date(),
    @ColumnInfo(name = "updatedAt") val updatedAt: Date? = null,
    @ColumnInfo(name = "deletedAt") val deletedAt: Date? = null
) : BaseEntity