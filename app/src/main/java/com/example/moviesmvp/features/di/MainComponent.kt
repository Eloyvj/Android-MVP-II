package com.example.moviesmvp.features.di

import com.example.moviesmvp.features.data.di.ApiModule
import com.example.moviesmvp.features.data.network.MyApiEndpointInterface
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApiModule::class])
interface MainComponent {
    val myApiEndpointInterface: MyApiEndpointInterface
}