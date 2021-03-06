package com.example.moviesmvp.di.module

import com.example.moviesmvp.data.network.MyApiEndpointInterface
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class ApiModule {
    @Provides
    @Singleton
    fun providesEndpoints(retrofit: Retrofit) = retrofit.create(MyApiEndpointInterface::class.java)
}