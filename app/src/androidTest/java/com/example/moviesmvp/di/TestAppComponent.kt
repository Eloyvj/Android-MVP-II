package com.example.moviesmvp.di

import com.example.moviesmvp.di.module.TestApiModule
import com.example.moviesmvp.di.module.TestAppModule
import com.example.moviesmvp.di.module.TestOkHttpModule
import com.example.moviesmvp.di.module.TestRetrofitModule
import com.example.moviesmvp.featuresandroidtest.popularmoviesandroid.PopularMoviesListAndroidTest
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [TestApiModule::class, TestAppModule::class, TestOkHttpModule::class, TestRetrofitModule::class])
interface TestAppComponent : AppComponent {

  /*  override fun application(): Application
    override fun gson(): Gson
    override fun resources(): Resources
    override fun retrofit(): Retrofit
    override fun endpoints(): MyApiEndpointInterface
    override fun cache(): Cache
    override fun client(): OkHttpClient
    override fun logginInterceptor(): HttpLoggingInterceptor
    override fun schedulerProvider(): BaseSchedulersImpl
    override fun movieMapper(): MovieMapper*/

    fun inject(test: PopularMoviesListAndroidTest)
}