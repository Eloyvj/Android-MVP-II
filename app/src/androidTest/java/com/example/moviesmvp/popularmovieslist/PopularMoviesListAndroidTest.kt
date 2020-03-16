package com.example.moviesmvp.popularmovieslist

import androidx.test.espresso.intent.rule.IntentsTestRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.example.moviesmvp.R
import com.example.moviesmvp.di.DaggerTestAppComponent
import com.example.moviesmvp.di.TestAppComponent
import com.example.moviesmvp.di.module.TestApiModule
import com.example.moviesmvp.di.module.TestAppModule
import com.example.moviesmvp.di.module.TestOkHttpModule
import com.example.moviesmvp.di.module.TestRetrofitModule
import com.example.moviesmvp.features.Application.App
import com.example.moviesmvp.features.popularmovieslist.PopularMoviesActivity
import okhttp3.mockwebserver.MockWebServer
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import javax.inject.Inject


@RunWith(AndroidJUnit4::class)
class PopularMoviesListAndroidTest {

    private val popularMoviesListFake = "popular_movies_full.json"
    private lateinit var testAppComponent: TestAppComponent

    @Inject
    lateinit var mockWebServer: MockWebServer

    @get:Rule
    var mActivityTestRule = IntentsTestRule(PopularMoviesActivity::class.java, true,
        false)

    @Before
    fun setUp() {
        val app = InstrumentationRegistry.getInstrumentation().getTargetContext().getApplicationContext() as App
        testAppComponent = DaggerTestAppComponent.builder()
            .testAppModule(TestAppModule(app))
            .testApiModule(TestApiModule())
            .testOkHttpModule(TestOkHttpModule())
            .testRetrofitModule(TestRetrofitModule())
            .build()
        App.appComponent = testAppComponent
        testAppComponent.inject(this)
    }

    @Test
    fun whenLoadPopularMoviesList_shouldShowAllFields() {
        popularMoviesList {
            mockService(popularMoviesListFake, mockWebServer)
            launchActivity(mActivityTestRule)

            var test: String = "TESTE - CARREGOU"
            System.out.println("===${test}")

            scrollToPositionInList(R.id.recyclerview_main_movies_list, 0)
            movieTitleIsDisplayed("Sonic the Hedgehog")
            moviePosterIsDisplayed(
                R.id.recyclerview_main_movies_list, 0,
                R.id.imageview_movielist_poster
            )
        }
    }

}