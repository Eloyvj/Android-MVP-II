package com.example.moviesmvp.features.moviedetails.di

import com.example.moviesmvp.baseSchedulers.BaseSchedulersImpl
import com.example.moviesmvp.di.ActivityScope
import com.example.moviesmvp.di.AppComponent
import com.example.moviesmvp.features.interactor.PopularMoviesInteractor
import com.example.moviesmvp.features.moviedetails.MovieDetailActivity
import com.example.moviesmvp.features.moviedetails.MovieDetailPresenter
import com.example.moviesmvp.features.moviedetails.MovieDetailPresenterImpl
import com.example.moviesmvp.features.moviedetails.MovieDetailView
import dagger.Component
import dagger.Provides
import dagger.Subcomponent

@ActivityScope
@Subcomponent(modules = [MovieDetailComponent.Module::class])
interface MovieDetailComponent {
    fun inject(activity: MovieDetailActivity)

    @dagger.Module
    class Module(private val view: MovieDetailView) {
        @Provides
        open fun providerMovieDetailView(): MovieDetailView {
            return MovieDetailActivity()
        }

        @Provides
        open fun providerMovieDetailPresenter(baseSchedulers: BaseSchedulersImpl,
                                              interactor: PopularMoviesInteractor
        ): MovieDetailPresenter {
            return MovieDetailPresenterImpl(view, baseSchedulers, interactor)
        }
    }
}