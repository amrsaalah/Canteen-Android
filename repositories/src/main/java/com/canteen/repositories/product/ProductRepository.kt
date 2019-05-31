package com.canteen.repositories.product

import com.canteen.base.utils.EventBus
import com.canteen.data.localDataSource.entry.IEntryLocalDataSource
import com.canteen.data.localDataSource.product.IProductLocalDataSource
import com.canteen.network.remoteDataSource.product.IProductRemoteDataSource
import com.canteen.repositories.BaseRepository
import javax.inject.Inject

/**
 * Created by Amr Salah on 5/31/2019.
 */
class ProductRepository @Inject constructor(
    private val productLocalDataSource: IProductLocalDataSource,
    private val productRemoteDataSource: IProductRemoteDataSource,
    private val eventBus: EventBus,
    private val entryLocalDataSource: IEntryLocalDataSource
) : BaseRepository(entryLocalDataSource), IProductRepository