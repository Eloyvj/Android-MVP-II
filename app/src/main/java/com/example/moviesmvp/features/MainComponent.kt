package com.example.moviesmvp.features

import com.example.moviesmvp.features.data.network.MyApiEndpointInterface
import com.example.moviesmvp.features.popularmovieslist.PopularMoviesFragment
import com.example.moviesmvp.features.popularmovieslist.PopularMoviesFragmentPresenter
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApiModule::class])
interface MainComponent {
    val myApiEndpointInterface: MyApiEndpointInterface
}