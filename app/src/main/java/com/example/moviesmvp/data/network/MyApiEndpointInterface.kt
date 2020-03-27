package com.example.moviesmvp.data.network

import com.example.moviesmvp.data.network.response.MovieDetailResponse
import com.example.moviesmvp.data.network.response.MoviesResult
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MyApiEndpointInterface {
    @GET("movie/popular")
    fun getPopularMovies(@Query("page") page: Int,
                         @Query("api_key") api_key: String): Observable<MoviesResult>

    @GET("movie/{movie_id}?&language=en-US")
    fun getMovieDetail(@Path("movie_id") movie_id: String,
                       @Query("api_key") api_key: String): Observable<MovieDetailResponse>
}