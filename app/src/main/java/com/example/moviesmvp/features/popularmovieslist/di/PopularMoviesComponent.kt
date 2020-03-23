package com.example.moviesmvp.features.popularmovieslist.di

import com.example.moviesmvp.di.ActivityScope
import com.example.moviesmvp.di.AppComponent
import com.example.moviesmvp.features.popularmovieslist.PopularMoviesFragment
import dagger.Component

@ActivityScope
@Component(dependencies = [AppComponent::class],modules = [PopularMoviesModule::class])
interface PopularMoviesComponent {
    fun inject (fragment: PopularMoviesFragment)
}