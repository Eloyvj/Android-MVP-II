package com.example.moviesmvp.features.popularmovieslist

import com.example.moviesmvp.features.ActivityScope
import com.example.moviesmvp.features.MainComponent
import com.example.moviesmvp.features.PopularMoviesModule
import com.example.moviesmvp.features.TestClass
import dagger.Component
import javax.inject.Singleton

@ActivityScope
@Component(dependencies = [MainComponent::class], modules = [PopularMoviesModule::class])
interface PopularMoviesComponent {
    fun inject (fragment: PopularMoviesFragment)
}