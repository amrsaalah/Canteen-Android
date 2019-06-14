package com.canteen.data.localDataSource.product

import androidx.sqlite.db.SimpleSQLiteQuery
import com.canteen.data.daos.ProductDao
import com.canteen.data.entities.Product
import timber.log.Timber
import javax.inject.Inject


/**
 * Created by Amr Salah on 5/19/2019.
 */
class ProductLocalDataSource @Inject constructor(private val productDao: ProductDao) : IProductLocalDataSource {


    override suspend fun getAllProducts(): List<Product> {
        return productDao.getProducts()
    }

    override suspend fun getProductsByCategoryId(categoryId: Int): List<Product> {
        return productDao.getProductByCategoryId(categoryId)
    }

    override suspend fun insert(entity: Product): Long {
        return productDao.insert(entity)
    }

    override suspend fun insertAll(entities: List<Product>) {
        return productDao.insertAll(entities)
    }

    override suspend fun update(entity: Product) {
        return productDao.update(entity)
    }

    override suspend fun delete(entity: Product): Int {
        return productDao.delete(entity)
    }

    override suspend fun getProductsFilteredList(
        pageNumber: Int,
        pageSize: Int,
        orderBy: String,
        categoryId: Int?,
        ratingFrom: Double?,
        ratingTo: Double?,
        search: String?
    ): List<Product> {
        val sqlQuery = StringBuilder()
        val args: ArrayList<Any> = arrayListOf()

        sqlQuery.append("Select * from products ")

        if (categoryId != null) {
            sqlQuery.append("where categoryId = ? ")
            args.add(categoryId)
        }

        if (ratingFrom != null && ratingTo != null) {
            if (sqlQuery.toString().isNotEmpty()) {
                sqlQuery.append("and ")
            } else {
                sqlQuery.append("where ")
            }

            sqlQuery.append("rating >= ? and rating <= ? ")
            args.addAll(listOf(ratingFrom, ratingTo))
        }

        sqlQuery.append("order by ? ")
        args.add(orderBy)

        Timber.d(sqlQuery.toString())
        val query = SimpleSQLiteQuery(sqlQuery.toString(), args.toArray())
        return productDao.getProductsFilteredList(query)
    }

}