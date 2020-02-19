package com.example.moviesmvp.features.popularmovieslist

import com.example.moviesmvp.features.Application.MainApplication
import com.example.moviesmvp.features.data.network.MyApiEndpointInterface
import com.example.moviesmvp.features.interactor.di.InteractorModule
import com.example.moviesmvp.features.interactor.PopularMoviesInteractor
import com.example.moviesmvp.features.interactor.di.DaggerInteractorComponent

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.internal.subscriptions.SubscriptionHelper
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class PopularMoviesFragmentPresenterImpl (private val view: PopularMoviesView) : PopularMoviesPresenter {

    @Inject
    lateinit var interactor: PopularMoviesInteractor

    private var pageNumber: Int = 1

    init {
        DaggerInteractorComponent
            .builder()
            .mainComponent(MainApplication.getComponent())
            .interactorModule(InteractorModule())
            .build()
            .inject(this)
    }

    override fun loadItems() {
        interactor.fetchPopularMovies(pageNumber++)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
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