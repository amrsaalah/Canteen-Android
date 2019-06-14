package com.canteen.repositories.data.product

/**
 * Created by Amr Salah on 6/14/2019.
 */
data class ProductFilter(
    val pageNumber: Int,
    val pageSize: Int,
    val orderBy: EProductOrder,
    val sortBy: EProductSort,
    val categoryId: Int? = null,
    val ratingFrom: Double? = null,
    val ratingTo: Double? = null,
    val query: String? = null
)