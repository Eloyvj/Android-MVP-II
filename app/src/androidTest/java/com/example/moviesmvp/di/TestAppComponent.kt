package com.example.moviesmvp.di

import com.example.moviesmvp.di.module.*
import com.example.moviesmvp.featuresandroidtest.popularmoviesandroid.PopularMoviesListAndroidTest
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [TestApiModule::class, TestAppModule::class, TestOkHttpModule::class,
    TestPopularMoviesInteractorModule::class, TestRetrofitModule::class])
interface TestAppComponent : AppComponent {
    fun inject(test: PopularMoviesListAndroidTest)
}