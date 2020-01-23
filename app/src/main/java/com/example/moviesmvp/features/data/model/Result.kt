package com.example.moviesmvp.features.data.model

import com.google.gson.annotations.SerializedName

data class Result (
    @SerializedName("id")
    var id: Int,
    @SerializedName("title")
    var title: String,
    @SerializedName("poster_path")
    var posterPath: String,
    var isFavorite: Boolean = false
)
