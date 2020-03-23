package com.example.moviesmvp.Application

import android.app.Application
import com.example.moviesmvp.di.AppComponent
import com.example.moviesmvp.di.DaggerAppComponent
import com.example.moviesmvp.di.module.AppModule

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