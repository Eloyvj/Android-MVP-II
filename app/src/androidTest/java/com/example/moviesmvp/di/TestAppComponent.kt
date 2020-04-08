package com.example.moviesmvp.di

import com.example.moviesmvp.di.module.*
import com.example.moviesmvp.featuresandroidtest.popularmoviesandroid.PopularMoviesListAndroidTest
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [TestApiModule::class, TestAppModule::class, TestOkHttpModule::class, TestPopularMoviesInteractorModule::class, TestRetrofitModule::class])
interface TestAppComponent : AppComponent {

    /*override fun application(): Application
    override fun gson(): Gson
    override fun resources(): Resources
    override fun retrofit(): Retrofit
    override fun endpoints(): MyApiEndpointInterface
    override fun cache(): Cache
    override fun client(): OkHttpClient
    override fun logginInterceptor(): HttpLoggingInterceptor
    override fun schedulerProvider(): BaseSchedulersImpl
    override fun movieMapper(): MovieMapper
    override fun popularMoviesInteractor(): PopularMoviesInteractor*/

    fun inject(test: PopularMoviesListAndroidTest)
}