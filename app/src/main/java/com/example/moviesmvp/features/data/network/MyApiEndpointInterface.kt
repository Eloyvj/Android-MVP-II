package com.example.moviesmvp.features.data.network

import com.example.moviesmvp.features.data.network.response.MovieResponse
import com.example.moviesmvp.features.data.network.response.MoviesResult
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MyApiEndpointInterface {
    @GET("movie/popular")
    fun getPopularMovies(@Query("page") page: Int,
                         @Query("api_key") api_key: String): Observable<MoviesResult>
}