package com.example.moviesmvp.popularmovieslist

import androidx.test.espresso.intent.rule.IntentsTestRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.example.moviesmvp.di.DaggerTestAppComponent
import com.example.moviesmvp.features.popularmovieslist.PopularMoviesActivity
import com.example.moviesmvp.testApplication.TestApplication
import okhttp3.mockwebserver.MockWebServer
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import javax.inject.Inject

@RunWith(AndroidJUnit4::class)
class PopularMoviesListAndroidTest {

    private val popularMoviesListFake = "popular_movies_full.json"

    @Inject
    lateinit var mockWebServer: MockWebServer

    @get:Rule
    var mActivityTestRule = IntentsTestRule(PopularMoviesActivity::class.java, true,
        false)

    @Before
    fun setUp() {
        TestApplication.getComponent()?.inject(this)
    }

    @Test
    fun whenLoadPopularMoviesList_shouldShowAllFields() {
        popularMoviesList {
            mockService(popularMoviesListFake, mockWebServer)
            launchActivity(mActivityTestRule)
            /*scrollToPositionInList(R.id.recyclerview_main_movies_list, 0)
            movieTitleIsDisplayed("Sonic the Hedgehog")
            moviePosterIsDisplayed(
                R.id.recyclerview_main_movies_list, 0,
                R.id.imageview_movielist_poster
            )*/
        }
    }

}