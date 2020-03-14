package com.example.moviesmvp.features.Application

import android.app.Application
import android.content.Context
import com.example.moviesmvp.features.di.AppComponent
import com.example.moviesmvp.features.di.DaggerAppComponent
import com.example.moviesmvp.features.di.module.AppModule

open class App: Application() {

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

    open fun initDagger() {
        appComponent = DaggerAppComponent.builder().appModule(AppModule(this)).build()
    }
}