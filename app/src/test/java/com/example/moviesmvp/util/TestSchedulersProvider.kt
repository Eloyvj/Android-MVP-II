package com.example.moviesmvp.util

import com.example.moviesmvp.features.baseSchedulers.BaseSchedulers
import io.reactivex.schedulers.TestScheduler

class TestSchedulersProvider(private val testScheduler: TestScheduler): BaseSchedulers {

    override fun io() = testScheduler

    override fun computation() = testScheduler

    override fun ui() = testScheduler
}