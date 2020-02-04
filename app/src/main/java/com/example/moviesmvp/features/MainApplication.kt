package com.example.moviesmvp.features

import android.app.Application
import androidx.core.content.ContextCompat.getSystemService

class MainApplication: Application() {

    companion object {
        private var component: Component? = null

        fun getComponent(): Component? {
            return component
        }
    }

    override fun onCreate() {
        super.onCreate()
        initDagger()
    }

    private fun initDagger() {
        component = DaggerComponent
            .builder()
            .build()
    }
}