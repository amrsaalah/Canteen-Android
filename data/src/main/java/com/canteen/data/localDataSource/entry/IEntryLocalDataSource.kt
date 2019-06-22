package com.canteen.data.localDataSource.entry

import com.canteen.data.entities.Entry
import com.canteen.data.localDataSource.BaseLocalDataSource

/**
 * Created by Amr Salah on 5/27/2019.
 */
interface IEntryLocalDataSource : BaseLocalDataSource<Entry> {

    suspend fun getAllEntries(): List<Entry>
    suspend fun getEntriesByApiAndStatus(api: Int, status: Int): List<Entry>
    suspend fun getLatestEntryByApi(api: Int): Entry?
    suspend fun getEntriesByStatus(status: Int): List<Entry>
    suspend fun getEntryById(entryId: Int): Entry?
    suspend fun deleteFromEntriesByApi(api: Int)
}