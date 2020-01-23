package com.example.moviesmvp.features.data.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CreateRetrofitImpl(): CreateRetrofit {
    override fun getApi() =
        apiInstance

    companion object {
        private lateinit var apiInstance: MyApiEndpointInterface

        fun createApi(url: String) {
            // Create interceptor for log
            val interceptor = HttpLoggingInterceptor()
            interceptor.level = HttpLoggingInterceptor.Level.BODY
            val client = OkHttpClient.Builder().addInterceptor(interceptor).build()
            // Create retrofit instance
            val retrofit = Retrofit.Builder()
                .baseUrl(url)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            apiInstance = retrofit.create(
                MyApiEndpointInterface::class.java)
        }
    }
}

interface CreateRetrofit {
    fun getApi(): MyApiEndpointInterface
}