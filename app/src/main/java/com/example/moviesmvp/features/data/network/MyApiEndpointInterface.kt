package com.example.moviesmvp.features.data.network

import com.example.moviesmvp.features.data.model.ResponseResult
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MyApiEndpointInterface {
    @GET("movie/popular?api_key=5a436d513d8fcb4f4e4138c77c24ca2a&language=en-US")
    fun getPopularMovies(@Query("page") page: Int): Call<ResponseResult>
}