package com.example.moviesmvp.features.moviedetails

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.moviesmvp.Application.App
import com.example.moviesmvp.R
import com.example.moviesmvp.data.model.Genre
import com.example.moviesmvp.data.model.MovieDetail
import com.example.moviesmvp.features.moviedetails.di.DaggerMovieDetailComponent
import com.example.moviesmvp.features.moviedetails.di.MovieDetailModule
import kotlinx.android.synthetic.main.activity_movie_detail.*
import kotlinx.android.synthetic.main.error_message_and_load_retry.*
import javax.inject.Inject

private const val PREFIX_URL_POSTER = "https://image.tmdb.org/t/p/w342"
private const val POSITION_OF_LAYOUT_PROGRESS_BAR = 0
private const val POSITION_OF_LAYOUT_MOVIE_DETAIL = 1
private const val POSITION_OF_LAYOUT_ERROR = 2

class MovieDetailActivity : AppCompatActivity(), MovieDetailView {

    private lateinit var movieId: String

    @Inject
    lateinit var presenter: MovieDetailPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)

        DaggerMovieDetailComponent
            .builder()
            .appComponent(App.getComponent())
            .movieDetailModule(MovieDetailModule(this))
            .build()
            .inject(this)

        movieId = this.intent.getStringExtra(MOVIE_ID);
        presenter.getMovieDetail(movieId.toInt())
    }

    override fun setupScreen(movieDetail: MovieDetail) {
        val toolbar = toolbar_detail
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val urlPoster = PREFIX_URL_POSTER + movieDetail.posterPath
        Glide.with(this)
            .load(urlPoster)
            .placeholder(R.drawable.ic_submit_progress)
            .error(R.drawable.ic_unavailable_poster_big)
            .into(imageview_moviedetail_poster)
        textview_moviedetail_title.text = movieDetail.title
        textview_moviedetail_year.text = getReleaseYear(movieDetail.releaseDate)
        textview_moviedetail_genre.text = getGenresNames(movieDetail.genres)
        textview_moviedetail_overview.text = movieDetail.overview
    }

    override fun reloadFromError() {
        button_main_load_movies.setOnClickListener {
            presenter.getMovieDetail(movieId.toInt())
        }
    }

    override fun showProgressBar() {
        viewflipper_moviedetail.setDisplayedChild(POSITION_OF_LAYOUT_PROGRESS_BAR)
    }

    override fun hideProgressBar() {
        viewflipper_moviedetail.setDisplayedChild(POSITION_OF_LAYOUT_MOVIE_DETAIL)
    }

    override fun showErrorLayout() {
        viewflipper_moviedetail.setDisplayedChild(POSITION_OF_LAYOUT_ERROR)
    }

    private fun getReleaseYear(fulldate: String): String {
        val dateAuxiliary = fulldate.split("-")
        return dateAuxiliary[0]
    }

    private fun getGenresNames(genres: List<Genre>): String {
        var names: String = ""
        for (genre in genres) {
            if (names == "") {
                names = genre.name
            } else {
                names = names + ", " + genre.name
            }
        }
        return names
    }

    companion object {
        private val MOVIE_ID = "movieId"

        fun newIntent(context: Context, movieId: String): Intent {
            return Intent(context, MovieDetailActivity::class.java).apply {
                putExtra(MOVIE_ID, movieId)
            }
        }
    }
}
