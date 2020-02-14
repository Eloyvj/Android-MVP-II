package com.example.moviesmvp.features.popularmovieslist.di

import com.example.moviesmvp.features.data.network.CreateRetrofit
import com.example.moviesmvp.features.data.network.MyApiEndpointInterface
import com.example.moviesmvp.features.popularmovieslist.*
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
open class PopularMoviesModule(var view: PopularMoviesView) {

    @Provides
    open fun provideViewForThisModule() : PopularMoviesView {
        return this.view
    }

    @Provides
    open fun providerPopularMoviesView(): PopularMoviesView {
        return PopularMoviesFragment()
    }

    @Provides
    open fun providerPopularMoviesPresenter(createRetrofit: MyApiEndpointInterface): PopularMoviesPresenter {
        return PopularMoviesFragmentPresenter(view, createRetrofit)
    }
}