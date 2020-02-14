package com.example.moviesmvp.features.Application

import android.app.Application
import com.example.moviesmvp.features.di.DaggerMainComponent
import com.example.moviesmvp.features.di.MainComponent

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
        mainComponent = DaggerMainComponent.builder()
            .build()
    }
}