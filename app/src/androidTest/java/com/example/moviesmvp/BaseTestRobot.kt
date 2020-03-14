package com.example.moviesmvp

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.*
import com.example.moviesmvp.utils.Utils
import org.hamcrest.Matchers

open class BaseTestRobot {
    fun fillEditText(resId: Int, text: String): ViewInteraction =
        onView(withId(resId))
            .perform(ViewActions.replaceText(text), ViewActions.closeSoftKeyboard())

    fun clickInView(resId: Int): ViewInteraction = onView((withId(resId)))
        .perform(ViewActions.click())

    fun matchViewByIdIsDisplayed(resId: Int): ViewInteraction = onView(withId(resId))
        .check(ViewAssertions.matches(isDisplayed()))

    fun matchButtonByTextIsDisplayed(text: String): ViewInteraction = onView(withText(text))
        .check(ViewAssertions.matches(isDisplayed()))

    fun matchTextViewByIdHaveString(resId: Int, text: String): ViewInteraction = onView(withId(resId))
        .check(ViewAssertions.matches(ViewMatchers.withText(text)))

    fun matchTextViewByTextIsDisplayed(text: String): ViewInteraction =
        onView(withText(text)).check(ViewAssertions.matches(isDisplayed()))

    fun matchButtonByIdIsClickable(resId: Int): ViewInteraction = onView(withId(resId))
        .check(ViewAssertions.matches(isClickable()))

    fun matchImageViewIntoRecyclerViewIsDisplayed(recyclerId: Int,
                                                  position: Int,
                                                  imageViewId: Int): ViewInteraction =
        onView(withId(recyclerId))
            .check(ViewAssertions.matches(
                Utils.withViewAtPosition(position,
                hasDescendant(
                    Matchers.allOf(withId(imageViewId),
                        isDisplayed())))
            ))

    fun matchImageViewWasLoadWithThisDrawable(imageViewId: Int, drawableId: Int) = onView(
        withId(imageViewId))
        .check(ViewAssertions.matches(Utils.withDrawable(drawableId)))
}