package com.canteen.data.daos

import androidx.room.Dao
import androidx.room.Query
import androidx.room.RawQuery
import androidx.sqlite.db.SupportSQLiteQuery
import com.canteen.data.entities.Product

/**
 * Created by Amr Salah on 5/19/2019.
 */

@Dao
interface ProductDao : BaseDao<Product>{

    @Query("select * from  products")
     suspend fun getProducts() : List<Product>

    @Query("select * from products where categoryId = :categoryId")
    suspend fun getProductByCategoryId(categoryId: Int): List<Product>

    @RawQuery
    suspend fun getProductsFilteredList(query: SupportSQLiteQuery): List<Product>

    @Query("select * from products where remoteId = :productRemoteId")
    suspend fun getProductByProductRemoteId(productRemoteId: String): Product?

    @Query("select * from products where isFavorite = 1")
    suspend fun getFavoriteProducts(): List<Product>
}