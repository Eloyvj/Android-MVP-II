package com.example.moviesmvp.baseSchedulers

import io.reactivex.schedulers.Schedulers

class TrampolineSchedulersProvider: BaseSchedulers {
    override fun io() = Schedulers.trampoline()

    override fun computation() = Schedulers.trampoline()

    override fun ui() = Schedulers.trampoline()
}