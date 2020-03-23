package com.example.moviesmvp.data.network.response

import com.google.gson.annotations.SerializedName

data class MovieResponse (
    @SerializedName("id")
    var id: Int,
    @SerializedName("poster_path")
    val posterPath: String,
    @SerializedName("original_title")
    val originalTitle:  String
)