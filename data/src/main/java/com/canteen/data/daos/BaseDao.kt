package com.canteen.data.daos

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Update
import com.canteen.data.entities.BaseEntity

/**
 * Created by Amr Salah on 5/19/2019.
 */


interface BaseDao<in E : BaseEntity> {
    @Insert
    suspend fun insert(entity: E): Long

    @Insert
    suspend fun insertAll(vararg entity: E)

    @Insert
    suspend fun insertAll(entities: List<E>)

    @Update
    suspend fun update(entity: E)

    @Delete
    suspend fun delete(entity: E): Int
}