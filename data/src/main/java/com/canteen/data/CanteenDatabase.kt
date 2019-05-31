package com.canteen.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.canteen.data.daos.CategoryDao
import com.canteen.data.daos.EntryDao
import com.canteen.data.daos.ProductDao
import com.canteen.data.entities.Category
import com.canteen.data.entities.Entry
import com.canteen.data.entities.Product

/**
 * Created by Amr Salah on 5/19/2019.
 */

@Database(
    entities = [Category::class, Product::class, Entry::class],
    version = 1 ,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class CanteenDatabase : RoomDatabase() {

    abstract fun productDao() : ProductDao
    abstract fun categoryDao() : CategoryDao
    abstract fun entryDao(): EntryDao
}