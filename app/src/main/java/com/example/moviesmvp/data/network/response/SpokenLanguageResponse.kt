package com.example.moviesmvp.data.network.response

import com.google.gson.annotations.SerializedName

data class SpokenLanguageResponse (
    @SerializedName("iso_639_1")
    val iso6391: String,
    @SerializedName("name")
    val name: String
)