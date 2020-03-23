package com.example.moviesmvp.di

import android.app.Application
import android.content.res.Resources
import com.example.moviesmvp.baseSchedulers.BaseSchedulersImpl
import com.example.moviesmvp.data.mapper.MovieMapper
import com.example.moviesmvp.data.network.MyApiEndpointInterface
import com.example.moviesmvp.di.module.ApiModule
import com.example.moviesmvp.di.module.AppModule
import com.example.moviesmvp.di.module.OkHttpModule
import com.example.moviesmvp.di.module.RetrofitModule
import com.google.gson.Gson
import dagger.Component
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, RetrofitModule::class, ApiModule::class, OkHttpModule::class])
interface AppComponent {
    /*val myApiEndpointInterface: MyApiEndpointInterface*/
    fun application(): Application
    fun gson(): Gson
    fun resources(): Resources
    fun retrofit(): Retrofit
    fun endpoints(): MyApiEndpointInterface
    fun cache(): Cache
    fun client(): OkHttpClient
    fun logginInterceptor(): HttpLoggingInterceptor
    fun schedulerProvider(): BaseSchedulersImpl
    fun movieMapper(): MovieMapper
}