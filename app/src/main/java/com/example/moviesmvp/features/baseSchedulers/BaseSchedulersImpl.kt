package com.example.moviesmvp.features.baseSchedulers

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class BaseSchedulersImpl: BaseSchedulers {

    override fun computation() = Schedulers.computation()

    override fun ui() = AndroidSchedulers.mainThread()

    override fun io() = Schedulers.io()
}