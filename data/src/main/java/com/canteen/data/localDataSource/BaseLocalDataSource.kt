package com.canteen.data.localDataSource

/**
 * Created by Amr Salah on 5/19/2019.
 */
interface BaseLocalDataSource<E> {

    suspend fun insert(entity: E): Long

    suspend fun insertAll(entities: List<E>)

    suspend fun update(entity: E)

    suspend fun delete(entity: E): Int
}