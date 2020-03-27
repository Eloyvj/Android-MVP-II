package com.example.moviesmvp.features.moviedetails

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.moviesmvp.data.model.MovieDetail
import com.example.moviesmvp.features.moviedetails.di.DaggerMovieDetailComponent
import com.example.moviesmvp.features.moviedetails.di.MovieDetailModule
import javax.inject.Inject

class MovieDetailActivity : AppCompatActivity(), MovieDetailView {
    @Inject
    lateinit var presenter: MovieDetailPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        DaggerMovieDetailComponent
            .builder()
            .movieDetailModule(MovieDetailModule(this))
            .build()
            .inject(this)
    }

    override fun setupScreen(movieDetail: MovieDetail) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun reloadFromError() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showProgressBar() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun hideProgressBar() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showErrorLayout() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
