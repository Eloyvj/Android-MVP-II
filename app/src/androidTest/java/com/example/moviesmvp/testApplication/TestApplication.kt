package com.example.moviesmvp.testApplication

import com.example.moviesmvp.di.DaggerTestAppComponent
import com.example.moviesmvp.di.TestAppComponent
import com.example.moviesmvp.di.module.TestAppModule
import com.example.moviesmvp.Application.App

class TestApplication : App() {

    companion object {
        @JvmStatic lateinit var testAppComponent: TestAppComponent

        fun getComponent(): TestAppComponent? {
            return testAppComponent
        }
    }

    override fun onCreate() {
        super.onCreate()
        initDagger()
    }

    override fun initDagger() {
        testAppComponent =  DaggerTestAppComponent.builder().testAppModule(TestAppModule(this)).build()
    }
}