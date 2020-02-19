package com.example.moviesmvp.features.interactor.di

import com.example.moviesmvp.features.data.network.MyApiEndpointInterface
import com.example.moviesmvp.features.interactor.PopularMoviesInteractor
import com.example.moviesmvp.features.interactor.PopularMoviesInteractorImpl
import dagger.Module
import dagger.Provides

@Module
open class InteractorModule {
    @Provides
    open fun providerPopularMoviesInteractor(retrofit: MyApiEndpointInterface): PopularMoviesInteractor {
        return PopularMoviesInteractorImpl(retrofit)
    }
}