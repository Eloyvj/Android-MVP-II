package com.example.moviesmvp.features.interactor

import com.example.moviesmvp.features.data.mapper.MovieMapper
import com.example.moviesmvp.features.data.model.Movie
import com.example.moviesmvp.features.data.network.MyApiEndpointInterface
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class PopularMoviesInteractorImpl (val createRetrofit: MyApiEndpointInterface
): PopularMoviesInteractor {

    override fun fetchPopularMovies(pageNumber: Int): Observable<List<Movie>> {
        val apiKey = "5a436d513d8fcb4f4e4138c77c24ca2a"
        return createRetrofit.getPopularMovies(pageNumber, apiKey)
            .subscribeOn(Schedulers.io())
            .observeOn(Schedulers.io())
            .map { MovieMapper.fromResponseToMovieDomain(it.moviesResult)
                .toList() }
    }
}