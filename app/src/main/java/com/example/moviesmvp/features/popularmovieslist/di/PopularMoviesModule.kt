package com.example.moviesmvp.features.popularmovieslist.di

import com.example.moviesmvp.features.baseSchedulers.BaseSchedulersImpl
import com.example.moviesmvp.features.popularmovieslist.PopularMoviesFragment
import com.example.moviesmvp.features.popularmovieslist.PopularMoviesFragmentPresenterImpl
import com.example.moviesmvp.features.popularmovieslist.PopularMoviesPresenter
import com.example.moviesmvp.features.popularmovieslist.PopularMoviesView
import dagger.Module
import dagger.Provides

@Module
open class PopularMoviesModule(private val view: PopularMoviesView) {

    private val baseSchedulers = BaseSchedulersImpl()

    @Provides
    open fun providerPopularMoviesView(): PopularMoviesView {
        return PopularMoviesFragment()
    }

    @Provides
    open fun providerPopularMoviesPresenter(): PopularMoviesPresenter {
        return PopularMoviesFragmentPresenterImpl(view, baseSchedulers)
    }
}