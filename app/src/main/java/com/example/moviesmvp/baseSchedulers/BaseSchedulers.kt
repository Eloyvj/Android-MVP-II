package com.example.moviesmvp.baseSchedulers

import io.reactivex.Scheduler

interface BaseSchedulers {
    fun io(): Scheduler
    fun computation(): Scheduler
    fun ui(): Scheduler
}