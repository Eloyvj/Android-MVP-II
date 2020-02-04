package com.example.moviesmvp.features

import com.example.moviesmvp.features.popularmovieslist.PopularMoviesFragment
import com.example.moviesmvp.features.popularmovieslist.PopularMoviesFragmentPresenter
import dagger.Component

@Component(modules = [Module::class, ApiModule::class])
interface Component {
    fun inject (fragment: PopularMoviesFragment)
    fun inject (popularMoviesFragmentPresenter: PopularMoviesFragmentPresenter)
    fun inject (testClass: TestClass)
}