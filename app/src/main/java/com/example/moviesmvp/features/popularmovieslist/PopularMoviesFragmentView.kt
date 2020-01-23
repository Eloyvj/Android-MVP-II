package com.example.moviesmvp.features.popularmovieslist

import com.example.moviesmvp.features.data.model.*

interface PopularMoviesFragmentView {
    fun setUpScrollListener()
    fun loadMoreItems() // o presenter + interactor
    fun setUpObservables() // o presenter + interactor
    fun setUpRecyclerView()
    fun reloadFromError()
    fun openMovieDetailActivity(movieId: Int)
    fun setUpListForAdapter(moviesList: List<Result>)
    fun showEmptySearchLayout()
    fun searchAllMoviesCaseQueryIsEmpty()
}