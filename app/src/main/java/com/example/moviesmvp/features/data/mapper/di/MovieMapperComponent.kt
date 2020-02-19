package com.example.moviesmvp.features.data.mapper.di

import com.example.moviesmvp.features.di.ActivityScope
import com.example.moviesmvp.features.interactor.PopularMoviesInteractorImpl
import dagger.Component

@ActivityScope
@Component(modules = [MovieMapperModule::class])
interface MovieMapperComponent {

    fun inject(popularMoviesInteractorImpl: PopularMoviesInteractorImpl)
}