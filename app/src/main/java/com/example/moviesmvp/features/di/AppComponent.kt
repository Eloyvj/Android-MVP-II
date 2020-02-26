package com.example.moviesmvp.features.di

import android.app.Application
import android.content.res.Resources
import com.example.moviesmvp.features.baseSchedulers.BaseSchedulersImpl
import com.example.moviesmvp.features.data.network.MyApiEndpointInterface
import com.example.moviesmvp.features.di.module.ApiModule
import com.example.moviesmvp.features.di.module.AppModule
import com.example.moviesmvp.features.di.module.OkHttpModule
import com.example.moviesmvp.features.di.module.RetrofitModule
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
}