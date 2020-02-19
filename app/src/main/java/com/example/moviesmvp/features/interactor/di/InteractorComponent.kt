package com.example.moviesmvp.features.interactor.di

import com.example.moviesmvp.features.di.ActivityScope
import com.example.moviesmvp.features.di.MainComponent
import com.example.moviesmvp.features.popularmovieslist.PopularMoviesFragmentPresenterImpl
import dagger.Component

@ActivityScope
@Component(dependencies = [MainComponent::class], modules = [InteractorModule::class])
interface InteractorComponent {
    fun inject(popularMoviesFragmentPresenterImpl: PopularMoviesFragmentPresenterImpl)
}