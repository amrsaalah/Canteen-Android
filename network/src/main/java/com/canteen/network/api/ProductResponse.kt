package com.canteen.network.api

import com.google.gson.annotations.SerializedName

/**
 * Created by Amr Salah on 6/15/2019.
 */
data class ProductResponse(
    @SerializedName("ProductId") val productId: String,
    @SerializedName("ProductName") val productName: String,
    @SerializedName("ProductDescription") val productDescription: String,
    @SerializedName("Image") val imageUrl: String,
    @SerializedName("UnitPrice") val price: Double,
    @SerializedName("CategoryId") val categoryId: String,
    @SerializedName("Rating") val rating: Double
)