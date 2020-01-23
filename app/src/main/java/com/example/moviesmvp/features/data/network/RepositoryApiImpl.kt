package com.example.moviesmvp.features.data.network

import com.example.moviesmvp.features.data.model.ResponseResult
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

private const val FAILURE_MESSAGE = "Um erro ocorreu. \nPor favor, tente novamente."

class RepositoryApiImpl(private val createRetrofit: CreateRetrofit):
    RepositoryApi {
    override fun popularMovies(page: Int, callback: CallBackPopularMovies) {
        val apiService = createRetrofit.getApi()
        apiService.getPopularMovies(page).enqueue(object : Callback<ResponseResult> {
            override fun onResponse(
                call: Call<ResponseResult>,
                response: Response<ResponseResult>
            ) {
                if (response.isSuccessful) {
                    val data = response.body()
                    data?.let {
                        callback.onSuccessGetPopularMovies(it)
                    }
                }
            }

            override fun onFailure(call: Call<ResponseResult>, t: Throwable) {
                callback.onErrorGetPopularMovies(FAILURE_MESSAGE)
            }
        })

    }
}

interface RepositoryApi {
    fun popularMovies(page: Int, callback: CallBackPopularMovies)
}

interface CallBackPopularMovies {
    fun onSuccessGetPopularMovies(responseResult: ResponseResult)
    fun onErrorGetPopularMovies(message: String)
}
