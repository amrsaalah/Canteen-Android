package com.canteen.data.daos

import androidx.room.Dao
import androidx.room.Query
import com.canteen.data.entities.Entry

/**
 * Created by Amr Salah on 5/27/2019.
 */
@Dao
interface EntryDao : BaseDao<Entry> {

    @Query("select * from  entries")
    suspend fun getEntries(): List<Entry>

    @Query("select * from entries where api = :api AND status = :status ")
    suspend fun getEntriesByApiAndStatus(api: Int, status: Int): List<Entry>

    @Query("select * from entries where api = :api ORDER BY createdAt DESC LIMIT 1")
    suspend fun getLatestEntryByApi(api: Int): Entry?

    @Query("select * from entries where status = :status")
    suspend fun getEntriesByStatus(status: Int): List<Entry>


    @Query("select * from entries where id = :entryId")
    suspend fun getEntryById(entryId: Int): Entry?

    @Query("delete from entries where api = :api")
    suspend fun deleteFromEntriesByApi(api: Int)
}