package com.example.moviesmvp.di

import android.app.Application
import android.content.res.Resources
import com.example.moviesmvp.di.module.TestApiModule
import com.example.moviesmvp.di.module.TestAppModule
import com.example.moviesmvp.di.module.TestOkHttpModule
import com.example.moviesmvp.di.module.TestRetrofitModule
import com.example.moviesmvp.features.baseSchedulers.BaseSchedulersImpl
import com.example.moviesmvp.features.data.mapper.MovieMapper
import com.example.moviesmvp.features.data.network.MyApiEndpointInterface
import com.example.moviesmvp.features.di.AppComponent
import com.example.moviesmvp.features.popularmovieslist.PopularMoviesFragment
import com.example.moviesmvp.popularmovieslist.PopularMoviesListAndroidTest
import com.google.gson.Gson
import dagger.BindsInstance
import dagger.Component
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.mockwebserver.MockWebServer
import retrofit2.Retrofit
import javax.inject.Inject
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