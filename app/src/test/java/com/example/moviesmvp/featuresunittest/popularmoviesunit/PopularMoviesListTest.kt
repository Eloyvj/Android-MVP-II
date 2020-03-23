package com.example.moviesmvp.featuresunittest.popularmoviesunit

import com.example.moviesmvp.data.mapper.MovieMapper
import com.example.moviesmvp.data.network.response.MovieResponse
import com.example.moviesmvp.features.interactor.PopularMoviesInteractor
import com.example.moviesmvp.features.popularmovieslist.PopularMoviesFragmentPresenterImpl
import com.example.moviesmvp.features.popularmovieslist.PopularMoviesPresenter
import com.example.moviesmvp.features.popularmovieslist.PopularMoviesView
import com.example.moviesmvp.util.TestSchedulersProvider
import com.example.moviesmvp.util.loadJson
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import io.reactivex.Observable
import io.reactivex.schedulers.TestScheduler
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mockito

@RunWith(JUnit4::class)
class PopularMoviesListTest {

    private val popularMoviesListFake = "popular_movies.json"

    val view: PopularMoviesView = mock()

    val interactor: PopularMoviesInteractor = mock()

    var presenter: PopularMoviesPresenter

    val mapper = MovieMapper()

    private var testScheduler: TestScheduler

    init {
        testScheduler = TestScheduler()
        val testSchedulerProvider = TestSchedulersProvider(testScheduler)
        presenter = PopularMoviesFragmentPresenterImpl(view, testSchedulerProvider, interactor)
    }

    @Test
    fun `send popular movies list for adapter after fetch from api`() {
        val list = mapper.fromResponseToMovieDomain(mockPopularMoviesList())
        whenever(interactor.fetchPopularMovies(1)).thenReturn(Observable.just(list))

        presenter.loadItems()

        testScheduler.triggerActions()

        verify(view, Mockito.times(1)).setUpListForAdapter(list)
    }

    private fun mockPopularMoviesList(): List<MovieResponse> {
        return loadJson(popularMoviesListFake)
    }
}
