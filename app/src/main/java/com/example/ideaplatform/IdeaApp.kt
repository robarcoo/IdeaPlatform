package com.example.ideaplatform

import android.app.Application
import com.example.core.di.android.ApplicationProvider
import com.example.core.di.IApp
import com.example.ideaplatform.di.ApplicationComponent

class IdeaApp : Application(), IApp {

    private lateinit var appComponent: ApplicationProvider

    override fun onCreate() {
        super.onCreate()
        appComponent = ApplicationComponent.init(this)
    }

    override fun getApplicationProvider(): ApplicationProvider {
        return appComponent
    }
}