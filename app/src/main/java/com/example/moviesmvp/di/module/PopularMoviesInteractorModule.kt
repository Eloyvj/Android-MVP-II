package com.example.moviesmvp.di.module

import com.example.moviesmvp.baseSchedulers.BaseSchedulersImpl
import com.example.moviesmvp.data.mapper.MovieMapper
import com.example.moviesmvp.data.network.MyApiEndpointInterface
import com.example.moviesmvp.features.interactor.PopularMoviesInteractor
import com.example.moviesmvp.features.interactor.PopularMoviesInteractorImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class PopularMoviesInteractorModule {
    @Provides
    @Singleton
    open fun providerPopularMoviesInteractor(retrofit: MyApiEndpointInterface,
                                             baseSchedulers: BaseSchedulersImpl,
                                             movieMapper: MovieMapper
    ): PopularMoviesInteractor {
        return PopularMoviesInteractorImpl(retrofit, baseSchedulers, movieMapper)
    }
}