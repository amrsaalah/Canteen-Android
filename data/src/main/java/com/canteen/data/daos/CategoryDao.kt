package com.canteen.data.daos

import androidx.room.Dao
import androidx.room.Query
import com.canteen.data.entities.Category

/**
 * Created by Amr Salah on 5/19/2019.
 */
@Dao
interface CategoryDao : BaseDao<Category>{

    @Query("select * from  categories")
    suspend fun getCategories(): List<Category>


    @Query("DELETE FROM categories")
    fun deleteAll()

    @Query("select * from categories where remoteId = :remoteId")
    fun getCategoryByRemoteId(remoteId: String): Category?
}