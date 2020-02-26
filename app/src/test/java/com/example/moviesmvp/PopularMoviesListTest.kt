package com.example.moviesmvp

import com.example.moviesmvp.features.baseSchedulers.TrampolineSchedulersProvider
import com.example.moviesmvp.features.data.mapper.MovieMapper
import com.example.moviesmvp.features.data.network.response.MovieResponse
import com.example.moviesmvp.features.interactor.PopularMoviesInteractor
import com.example.moviesmvp.features.popularmovieslist.PopularMoviesFragmentPresenterImpl
import com.example.moviesmvp.features.popularmovieslist.PopularMoviesPresenter
import com.example.moviesmvp.features.popularmovieslist.PopularMoviesView
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import io.reactivex.Observable
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class PopularMoviesListTest {

    val view: PopularMoviesView = mock()

    val interactor: PopularMoviesInteractor = mock()

    var presenter: PopularMoviesPresenter

    val mapper = MovieMapper()

    private var schedulerProvider: TrampolineSchedulersProvider

    @Before
    fun setUp() {
    }

    init {
        schedulerProvider = TrampolineSchedulersProvider()
        presenter = PopularMoviesFragmentPresenterImpl(view, schedulerProvider)
    }

    @Test
    fun `xpto`() {
        val list = mapper.fromResponseToMovieDomain(mockPopularMoviesList())
        whenever(interactor.fetchPopularMovies(any())).thenReturn(Observable.just(list))
        verify(view).setUpListForAdapter(list)

    }

    private fun mockPopularMoviesList(): List<MovieResponse> {
        return loadJson("/json/popular_movies.json")
    }
}
