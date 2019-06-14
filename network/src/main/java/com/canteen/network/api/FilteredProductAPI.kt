package com.canteen.network.api

import com.google.gson.annotations.SerializedName

/**
 * Created by Amr Salah on 6/14/2019.
 */
data class ProductSearchRequest(
    @SerializedName("ProductName") var productName: String? = null,
    @SerializedName("CategoryId") var categoryId: String? = null,
    @SerializedName("RatingFrom") var ratingFrom: Double? = null,
    @SerializedName("RatingTo") var ratingTo: Double? = null
)

data class ProductFilterRequest(
    @SerializedName("PageNumber") val pageNumber: Int,
    @SerializedName("PageSize") val pageSize: Int,
    @SerializedName("SortBy") val sortBy: String,
    @SerializedName("SortDirection") val sortDirection: String,
    @SerializedName("SearchObject") var searchRequest: ProductSearchRequest = ProductSearchRequest()
)


data class ProductFilteredListResponse(
    @SerializedName("TotalRecords") val totalRecords: Int,
    @SerializedName("Results") val products: List<ProductResponse>
)

