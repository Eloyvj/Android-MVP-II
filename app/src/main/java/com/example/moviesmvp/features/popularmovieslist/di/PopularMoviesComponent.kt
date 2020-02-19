package com.example.moviesmvp.features.popularmovieslist.di

import com.example.moviesmvp.features.di.ActivityScope
import com.example.moviesmvp.features.di.MainComponent
import com.example.moviesmvp.features.popularmovieslist.PopularMoviesFragment
import dagger.Component

@ActivityScope
@Component(modules = [PopularMoviesModule::class])
interface PopularMoviesComponent {
    fun inject (fragment: PopularMoviesFragment)
}