package com.example.moviesmvp.features.interactor.di

import com.example.moviesmvp.features.di.ActivityScope
import com.example.moviesmvp.features.di.AppComponent
import com.example.moviesmvp.features.popularmovieslist.PopularMoviesFragmentPresenterImpl
import dagger.Component

@ActivityScope
@Component(dependencies = [AppComponent::class], modules = [InteractorModule::class])
interface InteractorComponent {
    fun inject(popularMoviesFragmentPresenterImpl: PopularMoviesFragmentPresenterImpl)
}