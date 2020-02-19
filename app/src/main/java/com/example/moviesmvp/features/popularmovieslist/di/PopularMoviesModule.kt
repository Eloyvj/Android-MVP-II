package com.example.moviesmvp.features.popularmovieslist.di

import com.example.moviesmvp.features.data.network.MyApiEndpointInterface
import com.example.moviesmvp.features.popularmovieslist.PopularMoviesFragment
import com.example.moviesmvp.features.popularmovieslist.PopularMoviesFragmentPresenterImpl
import com.example.moviesmvp.features.popularmovieslist.PopularMoviesPresenter
import com.example.moviesmvp.features.popularmovieslist.PopularMoviesView
import dagger.Module
import dagger.Provides

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
        return PopularMoviesFragmentPresenterImpl(view)
    }
}