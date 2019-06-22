package com.canteen.data.localDataSource.entry

import com.canteen.data.daos.EntryDao
import com.canteen.data.entities.Entry
import javax.inject.Inject

/**
 * Created by Amr Salah on 5/27/2019.
 */
class EntryLocalDataSource @Inject constructor(private val entryDao: EntryDao) :
    IEntryLocalDataSource {
    override suspend fun deleteFromEntriesByApi(api: Int) {
        return entryDao.deleteFromEntriesByApi(api)
    }

    override suspend fun getEntryById(entryId: Int): Entry? {
        return entryDao.getEntryById(entryId)
    }

    override suspend fun getEntriesByStatus(status: Int): List<Entry> {
        return entryDao.getEntriesByStatus(status)
    }

    override suspend fun insert(entity: Entry) = entryDao.insert(entity)

    override suspend fun insertAll(entities: List<Entry>) = entryDao.insertAll(entities)

    override suspend fun update(entity: Entry) = entryDao.update(entity)

    override suspend fun delete(entity: Entry): Int = entryDao.delete(entity)


    override suspend fun getAllEntries(): List<Entry> = entryDao.getEntries()

    override suspend fun getEntriesByApiAndStatus(api: Int, status: Int) =
        entryDao.getEntriesByApiAndStatus(api, status)

    override suspend fun getLatestEntryByApi(api: Int) = entryDao.getLatestEntryByApi(api)
}
