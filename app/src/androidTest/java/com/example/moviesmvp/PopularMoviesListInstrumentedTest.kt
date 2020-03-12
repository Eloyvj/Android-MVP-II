package com.example.moviesmvp

import androidx.test.espresso.intent.rule.IntentsTestRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.moviesmvp.features.popularmovieslist.PopularMoviesActivity
import com.example.moviesmvp.features.popularmovieslist.PopularMoviesFragment
import com.google.gson.Gson
import org.junit.Rule
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import retrofit2.Retrofit
import javax.inject.Inject

@RunWith(AndroidJUnit4::class)
class PopularMoviesListInstrumentedTest {

    @Inject
    lateinit var retrofit: Retrofit

    @get:Rule
    var mActivityTestRule = IntentsTestRule(PopularMoviesActivity::class.java, false, true)


}