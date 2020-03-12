package com.example.moviesmvp.di.module

import com.example.moviesmvp.BuildConfig
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.mockwebserver.MockWebServer
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class TestRetrofitModule {

    private val mockWebServer: MockWebServer by lazy { MockWebServer() }

    @Provides
    @Singleton
    fun provideMockWebServer(): MockWebServer {
        val thread = Thread(Runnable {
            mockWebServer.shutdown()
            mockWebServer.start()
        })
        thread.start()
        thread.join()
        return mockWebServer
    }

    @Provides
    @Singleton
    fun providesCreateRetrofit(client: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(mockWebServer.url("/"))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}