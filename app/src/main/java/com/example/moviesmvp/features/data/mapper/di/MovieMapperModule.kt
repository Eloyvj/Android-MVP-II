package com.example.moviesmvp.features.data.mapper.di

import com.example.moviesmvp.features.data.mapper.MovieMapper
import dagger.Module
import dagger.Provides

@Module
open class MovieMapperModule {

    @Provides
    open fun providerMapper(): MovieMapper {
        return MovieMapper()
    }
}