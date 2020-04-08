package com.example.moviesmvp.di

import android.app.Application
import android.content.res.Resources
import com.example.moviesmvp.Application.App
import com.example.moviesmvp.baseSchedulers.BaseSchedulersImpl
import com.example.moviesmvp.data.mapper.MovieMapper
import com.example.moviesmvp.data.network.MyApiEndpointInterface
import com.example.moviesmvp.di.module.*
import com.example.moviesmvp.features.interactor.PopularMoviesInteractor
import com.example.moviesmvp.features.interactor.PopularMoviesInteractorImpl
import com.example.moviesmvp.features.moviedetails.di.MovieDetailComponent
import com.example.moviesmvp.features.popularmovieslist.di.PopularMoviesComponent
import com.google.gson.Gson
import dagger.Component
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, RetrofitModule::class, ApiModule::class,
    OkHttpModule::class, PopularMoviesInteractorModule::class])
interface AppComponent {
   /* fun application(): Application
    fun gson(): Gson
    fun resources(): Resources
    fun retrofit(): Retrofit
    fun endpoints(): MyApiEndpointInterface
    fun cache(): Cache
    fun client(): OkHttpClient
    fun logginInterceptor(): HttpLoggingInterceptor
    fun schedulerProvider(): BaseSchedulersImpl
    fun movieMapper(): MovieMapper
    fun popularMoviesInteractor(): PopularMoviesInteractor*/
    fun inject(app: App)

    fun plus(popularMoviesModules: PopularMoviesComponent.Module): PopularMoviesComponent
    fun plus(movieDetailModules: MovieDetailComponent.Module): MovieDetailComponent
}