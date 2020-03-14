package com.example.moviesmvp.popularmovieslist

import android.widget.EditText
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.pressImeActionButton
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.intent.Intents.intended
import androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent
import androidx.test.espresso.intent.matcher.IntentMatchers.hasExtra
import androidx.test.espresso.intent.rule.IntentsTestRule
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.*
import com.example.moviesmvp.BaseTestRobot
import com.example.moviesmvp.features.popularmovieslist.PopularMoviesActivity
import com.example.moviesmvp.features.popularmovieslist.PopularMoviesAdapter
import com.example.moviesmvp.utils.Utils
import com.example.moviesmvp.utils.loadResponse
import okhttp3.mockwebserver.Dispatcher
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import okhttp3.mockwebserver.RecordedRequest
import org.hamcrest.CoreMatchers.allOf

fun popularMoviesList(func: PopularMoviesListRobot.() -> Unit) = PopularMoviesListRobot().apply { func() }

class PopularMoviesListRobot: BaseTestRobot() {
    fun launchActivity(intentTestRule: IntentsTestRule<PopularMoviesActivity>) {
        intentTestRule.launchActivity(null)
    }

    fun mockService(fileName: String, mockWebServer: MockWebServer) {
        val responseBody = fileName.loadResponse()

        val dispatcher = object : Dispatcher() {
            @Throws(InterruptedException::class)
            override fun dispatch(request: RecordedRequest): MockResponse {
                return when {
                    request.path.contains("movie/popular") -> {
                        MockResponse().setResponseCode(200).setBody(responseBody)
                    }
                    else -> MockResponse().setResponseCode(404)
                }
            }
        }
        mockWebServer.setDispatcher(dispatcher)
    }

    fun movieTitleIsDisplayed(title: String) = matchTextViewByTextIsDisplayed(title)

    fun moviePosterIsDisplayed(recyclerId: Int, position: Int, imageViewId: Int) =
        matchImageViewIntoRecyclerViewIsDisplayed(recyclerId, position, imageViewId)

    fun favoriteIconIsDisplayed(recyclerId: Int, position: Int, imageViewId: Int) =
        matchImageViewIntoRecyclerViewIsDisplayed(recyclerId, position, imageViewId)

    fun scrollToPositionInList(recyclerId: Int, position: Int) = onView(ViewMatchers.withId(recyclerId))
        .perform(RecyclerViewActions.scrollToPosition<PopularMoviesAdapter.ViewHolder>(position))

    fun clickOnPositionInList(recyclerId: Int, position: Int) = onView(ViewMatchers.withId(recyclerId))
        .perform(RecyclerViewActions.actionOnItemAtPosition<PopularMoviesAdapter.ViewHolder>(position,
            ViewActions.click()))

    fun intendedMovieDetail(className: String,
                            extraKeyMovieId: String,
                            extraValueMovieId: String) {
        intended(hasComponent(className))
        intended(hasExtra(extraKeyMovieId, extraValueMovieId))
    }

    fun fillSearchView(text: String) = onView(isAssignableFrom(EditText::class.java))
        .perform(typeText(text), pressImeActionButton())

    fun emptyStateMessageForSearchIsDisplayed(text: String) = matchTextViewByTextIsDisplayed(text)

    fun emptyStateImageForSearchIsDisplayed(resId: Int) = matchViewByIdIsDisplayed(resId)

    fun movieTitleSearchedIsDisplayed(recyclerId: Int, position: Int, text: String) =
        onView(withId(recyclerId)).check(matches(
            Utils.withViewAtPosition(position,
            hasDescendant(allOf(withText(text), isDisplayed())))))
}