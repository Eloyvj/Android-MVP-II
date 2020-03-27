package com.example.moviesmvp.features.moviedetails

import com.example.moviesmvp.baseSchedulers.BaseSchedulers
import com.example.moviesmvp.features.interactor.PopularMoviesInteractor

class MovieDetailPresenterImpl(private val view: MovieDetailView,
                               private val baseSchedulers: BaseSchedulers,
                               private val interactor: PopularMoviesInteractor
) : MovieDetailPresenter {
    override fun getMovieDetail(movieId: Int) {
        interactor.fetchMovieDetail(movieId)
            .subscribeOn(baseSchedulers.io())
            .observeOn(baseSchedulers.ui())
            .doOnSubscribe{view.showProgressBar()}
            .doOnTerminate{view.hideProgressBar()}
            .subscribe({
                view.setupScreen(it)
            }, {
                view.showErrorLayout()
                view.reloadFromError()
            })
    }
}