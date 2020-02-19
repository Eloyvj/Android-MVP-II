package com.example.moviesmvp.features.data.network.di

import com.example.moviesmvp.BuildConfig
import com.example.moviesmvp.features.data.network.MyApiEndpointInterface
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
open class ApiModule {

    @Provides
    @Singleton
    open fun createInterceptor(): OkHttpClient {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        return OkHttpClient.Builder().addInterceptor(interceptor).build()
    }

    @Provides
    @Singleton
    open fun providerCreateRetrofit(interceptor: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.base_url)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(interceptor)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    open fun getApiService(retrofit: Retrofit) = retrofit.create(MyApiEndpointInterface::class.java)
}