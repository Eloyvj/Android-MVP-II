package com.example.moviesmvp.features.moviedetails.di

import com.example.moviesmvp.di.ActivityScope
import com.example.moviesmvp.di.AppComponent
import com.example.moviesmvp.features.moviedetails.MovieDetailActivity
import dagger.Component

@ActivityScope
@Component(dependencies = [AppComponent::class], modules = [MovieDetailModule::class])
interface MovieDetailComponent {
    fun inject(activity: MovieDetailActivity)
}