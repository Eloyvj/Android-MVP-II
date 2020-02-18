package com.example.moviesmvp.features.interactor

import com.example.moviesmvp.features.data.model.Movie
import io.reactivex.Observable

interface PopularMoviesInteractor {

    fun fetchPopularMovies(pageNumber: Int): Observable<List<Movie>>
}