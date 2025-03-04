package com.example.ideaplatform.di

import com.example.core.di.android.AndroidDependenciesComponent
import com.example.core.di.android.ApplicationProvider
import com.example.ideaplatform.IdeaApp
import dagger.Component

interface ApplicationComponent : ApplicationProvider {

    companion object {

        fun init(app: IdeaApp) : ApplicationProvider {

            val androidDependenciesProvider = AndroidDependenciesComponent.create(app)

            return DaggerApplicationComponent.factory()
                .create(
                    androidDependenciesProvider,
                )
        }
    }

    @Component.Factory
    interface Factory {
        fun create(
            androidDependenciesProvider: AndroidDependenciesProvider,
        ): ApplicationComponent
    }

}