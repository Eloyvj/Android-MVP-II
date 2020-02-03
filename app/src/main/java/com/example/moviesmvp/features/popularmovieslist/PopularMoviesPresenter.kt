package com.example.moviesmvp.features.popularmovieslist

interface PopularMoviesPresenter {

    fun loadItems()
    fun destroyView()
}