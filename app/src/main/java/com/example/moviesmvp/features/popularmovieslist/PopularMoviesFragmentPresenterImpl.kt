package com.example.moviesmvp.features.popularmovieslist

import com.example.moviesmvp.features.Application.App
import com.example.moviesmvp.features.baseSchedulers.BaseSchedulers
import com.example.moviesmvp.features.interactor.di.InteractorModule
import com.example.moviesmvp.features.interactor.PopularMoviesInteractor
import com.example.moviesmvp.features.interactor.di.DaggerInteractorComponent

import javax.inject.Inject

class PopularMoviesFragmentPresenterImpl (private val view: PopularMoviesView,
                                          private val baseSchedulers: BaseSchedulers
)
    : PopularMoviesPresenter {

    @Inject
    lateinit var interactor: PopularMoviesInteractor

    private var pageNumber: Int = 1

    init {
        DaggerInteractorComponent
            .builder()
            .appComponent(App.getComponent())
            .interactorModule(InteractorModule())
            .build()
            .inject(this)
    }

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