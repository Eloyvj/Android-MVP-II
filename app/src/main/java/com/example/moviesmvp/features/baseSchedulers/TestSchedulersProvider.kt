package com.example.moviesmvp.features.baseSchedulers

import io.reactivex.schedulers.TestScheduler

class TestSchedulersProvider(private val scheduler: TestScheduler): BaseSchedulers {
    override fun io() = scheduler

    override fun computation() = scheduler

    override fun ui() = scheduler
}