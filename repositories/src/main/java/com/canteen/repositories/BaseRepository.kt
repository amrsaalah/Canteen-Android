package com.canteen.repositories

import com.canteen.data.localDataSource.entry.IEntryLocalDataSource
import com.canteen.network.enums.EApi
import timber.log.Timber

/**
 * Created by Amr Salah on 5/31/2019.
 */
abstract class BaseRepository(private val entryLocalDataSource: IEntryLocalDataSource) {

    companion object {
        private const val FETCH_TIME_PERIOD = 1L //in min
    }

    suspend fun shouldFetch(api: EApi): Boolean {
        val entry = entryLocalDataSource.getLatestEntryByApi(api.ordinal)
        Timber.d(entry.toString())
        return if (entry != null) {
            entry.createdAt.time < System.currentTimeMillis() - (FETCH_TIME_PERIOD * 60 * 1000)
        } else {
            true
        }

    }
}