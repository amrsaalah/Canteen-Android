package com.canteen.data.di

import android.app.Application
import androidx.room.Room
import com.canteen.base.di.scopes.AppScope
import com.canteen.data.CanteenDatabase
import com.canteen.data.daos.CategoryDao
import com.canteen.data.daos.EntryDao
import com.canteen.data.daos.ProductDao
import dagger.Module
import dagger.Provides

/**
 * Created by Amr Salah on 5/19/2019.
 */
@Module(includes = [LocalDataSourceModule::class])
class RoomModule{

    @AppScope
    @Provides
    fun providesRoomDatabase(app: Application): CanteenDatabase {
        return Room.databaseBuilder(app, CanteenDatabase::class.java, "canteen").build()
    }

    @AppScope
    @Provides
    fun provideProductDao(db: CanteenDatabase): ProductDao {
        return db.productDao()
    }


    @AppScope
    @Provides
    fun provideCategoryDao(db: CanteenDatabase): CategoryDao {
        return db.categoryDao()
    }


    @AppScope
    @Provides
    fun provideEntryDao(db: CanteenDatabase): EntryDao {
        return db.entryDao()
    }
}