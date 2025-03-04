package com.example.core.di.android

import android.app.Application
import android.content.Context
import com.example.core.database.ItemDatabase

interface AndroidDependenciesProvider {

    fun provideApplication(): Application

    fun provideContext(): Context

    fun getDatabase(): ItemDatabase
}