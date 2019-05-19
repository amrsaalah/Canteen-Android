package com.canteen.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created by Amr Salah on 5/19/2019.
 */

@Entity(tableName = "categories")
data class Category(@PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") override val id : Int = 0 ,
                    @ColumnInfo(name = "name") val name : String) : BaseEntity