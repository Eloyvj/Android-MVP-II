package com.example.moviesmvp.features.di.module

import android.app.Application
import com.example.moviesmvp.features.baseSchedulers.BaseSchedulersImpl
import com.example.moviesmvp.features.data.mapper.MovieMapper
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(val application: Application) {

    @Provides
    @Singleton
    fun providesGson() = GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ").create()

    @Provides
    @Singleton
    fun providesApplication() = application

    @Provides
    @Singleton
    fun providesResources() = application.resources

    @Provides
    @Singleton
    fun provideSchedulerProvider() = BaseSchedulersImpl()

    @Provides
    @Singleton
    fun provideMovieMapper() = MovieMapper()
}