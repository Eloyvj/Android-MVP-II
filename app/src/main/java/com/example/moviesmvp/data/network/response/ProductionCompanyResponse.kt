package com.example.moviesmvp.data.network.response

import com.google.gson.annotations.SerializedName

data class ProductionCompanyResponse (
    @SerializedName("id")
    val id: Int,
    @SerializedName("logo_path")
    val logoPath: Any,
    @SerializedName("name")
    val name: String,
    @SerializedName("origin_country")
    val originCountry: String
)