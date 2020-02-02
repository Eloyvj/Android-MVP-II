package com.example.moviesmvp.features.popularmovieslist

import com.example.moviesmvp.features.data.mapper.MovieMapper
import com.example.moviesmvp.features.data.network.CreateRetrofit
import com.example.moviesmvp.features.data.network.response.MoviesResult
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PopularMoviesFragmentPresenter(view: PopularMoviesFragmentContract.PopularMoviesView)
    : PopularMoviesFragmentContract.PopularMoviesPresenter {

    private var view: PopularMoviesFragmentContract.PopularMoviesView?
    private val createRetrofit: CreateRetrofit = CreateRetrofit()
    private var pageNumber: Int = 1

    init {
        this.view = view
    }

    override fun loadItems() {
        view?.showProgressBar()
        val apiKey = "5a436d513d8fcb4f4e4138c77c24ca2a"
        createRetrofit.getApiService().getPopularMovies(pageNumber++, apiKey).enqueue(object :
            Callback<MoviesResult> {
            override fun onResponse(call: Call<MoviesResult>, response: Response<MoviesResult>) {
                if (response.isSuccessful) {
                    response.body()?.let {
                        var listMovie = MovieMapper.fromResponseToMovieDomain(it.moviesResult)
                        view?.setUpListForAdapter(listMovie)
                    }
                }
            }

            override fun onFailure(call: Call<MoviesResult>, t: Throwable) {
                view?.showErrorLayout()
                view?.reloadFromError()
            }
        })
    }

    override fun destroyView() {
        view = null
    }
}