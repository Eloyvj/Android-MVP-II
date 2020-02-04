package com.example.moviesmvp.features

import android.app.Application

class MainApplication: Application() {

    companion object {
        private var mainComponent: MainComponent? = null

        fun getComponent(): MainComponent? {
            return mainComponent
        }
    }

    override fun onCreate() {
        super.onCreate()
        initDagger()
    }

    private fun initDagger() {
        mainComponent = DaggerMainComponent
            .builder()
            .build()
    }
}