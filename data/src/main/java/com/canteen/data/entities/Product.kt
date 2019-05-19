package com.canteen.data.entities

import androidx.room.*

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
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") override val id: Int = 0,
    @ColumnInfo(name = "categoryId") val categoryId: Int = 0,
    @ColumnInfo(name = "name") val name: String
) : BaseEntity