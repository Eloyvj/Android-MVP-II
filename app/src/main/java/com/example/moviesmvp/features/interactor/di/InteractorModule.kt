package com.example.moviesmvp.features.interactor.di

import com.example.moviesmvp.features.baseSchedulers.BaseSchedulersImpl
import com.example.moviesmvp.features.data.mapper.MovieMapper
import com.example.moviesmvp.features.data.network.MyApiEndpointInterface
import com.example.moviesmvp.features.interactor.PopularMoviesInteractor
import com.example.moviesmvp.features.interactor.PopularMoviesInteractorImpl
import dagger.Module
import dagger.Provides

@Module
open class InteractorModule {

    private val baseSchedulers = BaseSchedulersImpl()
    private val movieMapper = MovieMapper()

    @Provides
    open fun providerPopularMoviesInteractor(retrofit: MyApiEndpointInterface): PopularMoviesInteractor {
        return PopularMoviesInteractorImpl(retrofit, baseSchedulers, movieMapper)
    }
}