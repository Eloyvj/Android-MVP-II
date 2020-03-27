package com.example.moviesmvp.features.popularmovieslist.di

import com.example.moviesmvp.baseSchedulers.BaseSchedulersImpl
import com.example.moviesmvp.data.mapper.MovieMapper
import com.example.moviesmvp.data.network.MyApiEndpointInterface
import com.example.moviesmvp.features.interactor.PopularMoviesInteractor
import com.example.moviesmvp.features.interactor.PopularMoviesInteractorImpl
import com.example.moviesmvp.features.popularmovieslist.PopularMoviesFragment
import com.example.moviesmvp.features.popularmovieslist.PopularMoviesFragmentPresenterImpl
import com.example.moviesmvp.features.popularmovieslist.PopularMoviesPresenter
import com.example.moviesmvp.features.popularmovieslist.PopularMoviesView
import dagger.Module
import dagger.Provides

@Module
open class PopularMoviesModule(private val view: PopularMoviesView) {

    @Provides
    open fun providerPopularMoviesView(): PopularMoviesView {
        return PopularMoviesFragment()
    }

    /*@Provides
    open fun providerPopularMoviesInteractor(retrofit: MyApiEndpointInterface,
                                             baseSchedulers: BaseSchedulersImpl,
                                             movieMapper: MovieMapper): PopularMoviesInteractor {
        return PopularMoviesInteractorImpl(retrofit, baseSchedulers, movieMapper)
    }*/

    @Provides
    open fun providerPopularMoviesPresenter(baseSchedulers: BaseSchedulersImpl,
                                            interactor: PopularMoviesInteractor): PopularMoviesPresenter {
        return PopularMoviesFragmentPresenterImpl(view, baseSchedulers, interactor)
    }
}