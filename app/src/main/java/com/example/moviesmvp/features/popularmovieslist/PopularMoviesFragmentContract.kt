package com.example.moviesmvp.features.popularmovieslist

import androidx.annotation.Nullable
import com.example.moviesmvp.features.data.model.Movie

interface PopularMoviesFragmentContract {

    interface PopularMoviesView {
        fun setUpListForAdapter(movies: List<Movie>)
        fun reloadFromError()
        fun showProgressBar()
        fun hideProgressBar()
        fun showErrorLayout()
    }

    interface PopularMoviesPresenter {
        fun loadItems()
        fun destroyView()
    }
}