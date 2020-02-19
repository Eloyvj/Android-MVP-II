package com.example.moviesmvp.features.interactor

import com.example.moviesmvp.features.data.mapper.MovieMapper
import com.example.moviesmvp.features.data.mapper.di.DaggerMovieMapperComponent
import com.example.moviesmvp.features.data.mapper.di.MovieMapperModule
import com.example.moviesmvp.features.data.model.Movie
import com.example.moviesmvp.features.data.network.MyApiEndpointInterface
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class PopularMoviesInteractorImpl (private val retrofit: MyApiEndpointInterface
): PopularMoviesInteractor {

    @Inject
    lateinit var movieMapper: MovieMapper

    init {
        DaggerMovieMapperComponent
            .builder()
            .movieMapperModule(MovieMapperModule())
            .build()
            .inject(this)
    }

    override fun fetchPopularMovies(pageNumber: Int): Observable<List<Movie>> {
        val apiKey = "5a436d513d8fcb4f4e4138c77c24ca2a"
        return retrofit.getPopularMovies(pageNumber, apiKey)
            .subscribeOn(Schedulers.io())
            .observeOn(Schedulers.io())
            .map { movieMapper.fromResponseToMovieDomain(it.moviesResult)
                .toList() }
    }
}