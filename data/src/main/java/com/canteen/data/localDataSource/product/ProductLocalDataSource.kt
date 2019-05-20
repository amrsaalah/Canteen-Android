package com.canteen.data.localDataSource.product

import com.canteen.data.daos.ProductDao
import com.canteen.data.entities.Product
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

}