package com.example.moviesmvp.features.popularmovieslist

import com.example.moviesmvp.features.data.model.Movie

interface PopularMoviesView {

    fun setUpListForAdapter(movies: List<Movie>)
    fun reloadFromError()
    fun showProgressBar()
    fun hideProgressBar()
    fun showErrorLayout()
}