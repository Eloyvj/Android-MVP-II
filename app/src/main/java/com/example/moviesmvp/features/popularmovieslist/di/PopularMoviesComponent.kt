package com.example.moviesmvp.features.popularmovieslist.di

import com.example.moviesmvp.baseSchedulers.BaseSchedulersImpl
import com.example.moviesmvp.di.ActivityScope
import com.example.moviesmvp.di.AppComponent
import com.example.moviesmvp.features.interactor.PopularMoviesInteractor
import com.example.moviesmvp.features.popularmovieslist.PopularMoviesFragment
import com.example.moviesmvp.features.popularmovieslist.PopularMoviesFragmentPresenterImpl
import com.example.moviesmvp.features.popularmovieslist.PopularMoviesPresenter
import com.example.moviesmvp.features.popularmovieslist.PopularMoviesView
import dagger.Component
import dagger.Provides
import dagger.Subcomponent

@ActivityScope
@Subcomponent(modules = [PopularMoviesComponent.Module::class])
interface PopularMoviesComponent {
    fun inject (fragment: PopularMoviesFragment)

    @dagger.Module
    class Module(private val view: PopularMoviesView) {
        @Provides
        open fun providerPopularMoviesView(): PopularMoviesView {
            return PopularMoviesFragment()
        }

        @Provides
        open fun providerPopularMoviesPresenter(baseSchedulers: BaseSchedulersImpl,
                                                interactor: PopularMoviesInteractor
        ): PopularMoviesPresenter {
            return PopularMoviesFragmentPresenterImpl(view, baseSchedulers, interactor)
        }
    }
}