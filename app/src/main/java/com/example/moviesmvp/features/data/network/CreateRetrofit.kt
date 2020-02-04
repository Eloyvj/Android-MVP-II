package com.example.moviesmvp.features.data.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CreateRetrofit() {
        private val url: String = "https://api.themoviedb.org/3/"

        private fun createInterceptor(): OkHttpClient {
            val interceptor = HttpLoggingInterceptor()
            interceptor.level = HttpLoggingInterceptor.Level.BODY
            return OkHttpClient.Builder().addInterceptor(interceptor).build()
        }

        private val retrofit = Retrofit.Builder()
            .baseUrl(url)
            .client(createInterceptor())
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        fun getApiService() = retrofit.create(MyApiEndpointInterface::class.java)
}