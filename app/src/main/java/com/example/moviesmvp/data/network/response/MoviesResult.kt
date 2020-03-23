package com.example.moviesmvp.data.network.response

import com.google.gson.annotations.SerializedName

data class MoviesResult (
    @SerializedName("results")
    val moviesResult: List<MovieResponse>

)