package com.example.moviesmvp.features.interactor

import com.example.moviesmvp.data.model.Movie
import com.example.moviesmvp.data.model.MovieDetail
import io.reactivex.Observable

interface PopularMoviesInteractor {

    fun fetchPopularMovies(pageNumber: Int): Observable<List<Movie>>
    fun fetchMovieDetail(movieId: Int): Observable<MovieDetail>
}