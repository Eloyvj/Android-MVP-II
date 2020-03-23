package com.example.moviesmvp.features.popularmovieslist

import com.example.moviesmvp.baseSchedulers.BaseSchedulers
import com.example.moviesmvp.features.interactor.PopularMoviesInteractor

class PopularMoviesFragmentPresenterImpl (private val view: PopularMoviesView,
                                          private val baseSchedulers: BaseSchedulers,
                                          private val interactor: PopularMoviesInteractor
)
    : PopularMoviesPresenter {

    private var pageNumber: Int = 1

    override fun loadItems() {
        interactor.fetchPopularMovies(pageNumber++)
            .subscribeOn(baseSchedulers.io())
            .observeOn(baseSchedulers.ui())
            .doOnSubscribe {view.showProgressBar()}
            .doOnTerminate{view.hideProgressBar()}
            .subscribe({
                view.setUpListForAdapter(it)
        }, {
                view.showErrorLayout()
                view.reloadFromError()
            })
    }

    override fun destroyView() {
//      view = null
    }
}