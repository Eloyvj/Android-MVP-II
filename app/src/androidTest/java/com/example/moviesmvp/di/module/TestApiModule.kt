package com.example.moviesmvp.di.module

import com.example.moviesmvp.features.data.network.MyApiEndpointInterface
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class TestApiModule {
    @Provides
    @Singleton
    fun providesEndpoints(retrofit: Retrofit) = retrofit.create(MyApiEndpointInterface::class.java)
}