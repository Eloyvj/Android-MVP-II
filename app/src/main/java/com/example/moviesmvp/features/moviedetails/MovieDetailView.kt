package com.example.moviesmvp.features.moviedetails

import com.example.moviesmvp.data.model.MovieDetail

interface MovieDetailView {
    fun setupScreen(movieDetail: MovieDetail)
    fun reloadFromError()
    fun showProgressBar()
    fun hideProgressBar()
    fun showErrorLayout()
}