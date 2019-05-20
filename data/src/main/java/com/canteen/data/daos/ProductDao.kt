package com.canteen.data.daos

import androidx.room.Dao
import androidx.room.Query
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
}