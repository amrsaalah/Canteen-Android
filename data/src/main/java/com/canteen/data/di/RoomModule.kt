package com.canteen.data.di

import android.app.Application
import androidx.room.Room
import com.canteen.base.di.scopes.AppScope
import com.canteen.data.CanteenDatabase
import com.canteen.data.daos.CategoryDao
import com.canteen.data.daos.ProductDao
import com.canteen.data.localDataSource.category.CategoryLocalDataSourceModule
import com.canteen.data.localDataSource.product.ProductLocalDataSourceModule
import dagger.Module
import dagger.Provides

/**
 * Created by Amr Salah on 5/19/2019.
 */
@Module(includes = [CategoryLocalDataSourceModule::class, ProductLocalDataSourceModule::class])
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

}