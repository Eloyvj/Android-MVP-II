package com.example.moviesmvp.features.moviedetails.di

import com.example.moviesmvp.baseSchedulers.BaseSchedulersImpl
import com.example.moviesmvp.features.interactor.PopularMoviesInteractor
import com.example.moviesmvp.features.interactor.PopularMoviesInteractorImpl
import com.example.moviesmvp.features.moviedetails.MovieDetailActivity
import com.example.moviesmvp.features.moviedetails.MovieDetailPresenter
import com.example.moviesmvp.features.moviedetails.MovieDetailPresenterImpl
import com.example.moviesmvp.features.moviedetails.MovieDetailView
import dagger.Module
import dagger.Provides

@Module
open class MovieDetailModule(private val view: MovieDetailView) {

    @Provides
    open fun providerMovieDetailView(): MovieDetailView {
        return MovieDetailActivity()
    }

    @Provides
    open fun providerMovieDetailPresenter(baseSchedulers: BaseSchedulersImpl,
                                            interactor: PopularMoviesInteractor): MovieDetailPresenter {
        return MovieDetailPresenterImpl(view, baseSchedulers, interactor)
    }
}