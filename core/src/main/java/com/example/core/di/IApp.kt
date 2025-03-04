package com.example.core.di

import com.example.core.di.android.ApplicationProvider

interface IApp {
    fun getApplicationProvider(): ApplicationProvider
}