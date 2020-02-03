package com.example.moviesmvp.features

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.moviesmvp.R
import com.example.moviesmvp.features.data.mapper.MovieMapper
import com.example.moviesmvp.features.data.network.CreateRetrofit
import com.example.moviesmvp.features.data.network.MyApiEndpointInterface
import com.example.moviesmvp.features.data.network.response.MoviesResult
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class TestClass: AppCompatActivity() {

    @Inject
    lateinit var createRetrofit: MyApiEndpointInterface

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_popular_movies)

        MainApplication.getComponent()?.inject(this)

        val apiKey = "5a436d513d8fcb4f4e4138c77c24ca2a"
        createRetrofit.getPopularMovies(1, apiKey).enqueue(object :
            Callback<MoviesResult> {
            override fun onResponse(call: Call<MoviesResult>, response: Response<MoviesResult>) {
                if (response.isSuccessful) {
                    response.body()?.let {
                        Toast.makeText(this@TestClass, "TESTE ${response.body()?.moviesResult?.get(0)?.originalTitle}", Toast.LENGTH_SHORT).show()
                    }
                }
            }

            override fun onFailure(call: Call<MoviesResult>, t: Throwable) {
            }
        })

    }
}