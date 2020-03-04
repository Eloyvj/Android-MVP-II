package com.example.moviesmvp.features.Application

import android.app.Application
import com.example.moviesmvp.features.di.AppComponent
import com.example.moviesmvp.features.di.DaggerAppComponent
import com.example.moviesmvp.features.di.module.AppModule

class App: Application() {

    companion object {
        @JvmStatic lateinit var appComponent: AppComponent

        fun getComponent(): AppComponent? {
            return appComponent
        }
    }

    override fun onCreate() {
        super.onCreate()
        initDagger()
    }

    private fun initDagger() {
        appComponent = DaggerAppComponent.builder().appModule(AppModule(this)).build()
    }
}