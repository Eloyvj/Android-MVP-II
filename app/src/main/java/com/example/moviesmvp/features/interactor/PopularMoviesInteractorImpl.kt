package com.example.moviesmvp.features.interactor

import com.example.moviesmvp.baseSchedulers.BaseSchedulers
import com.example.moviesmvp.data.mapper.MovieMapper
import com.example.moviesmvp.data.model.Movie
import com.example.moviesmvp.data.network.MyApiEndpointInterface
import io.reactivex.Observable

class PopularMoviesInteractorImpl (private val retrofit: MyApiEndpointInterface,
                                   private val baseSchedulers: BaseSchedulers,
                                   private val movieMapper: MovieMapper
): PopularMoviesInteractor {

    override fun fetchPopularMovies(pageNumber: Int): Observable<List<Movie>> {
        val apiKey = "5a436d513d8fcb4f4e4138c77c24ca2a"
        return retrofit.getPopularMovies(pageNumber, apiKey)
            .subscribeOn(baseSchedulers.io())
            .observeOn(baseSchedulers.io())
            .map { movieMapper.fromResponseToMovieDomain(it.moviesResult)
                .toList() }
    }
}