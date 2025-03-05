package com.example.ideaplatform.di

import com.example.core.di.android.ApplicationProvider
import com.example.feature.di.UseCaseModule
import com.example.ideaplatform.IdeaApp
import dagger.Component


@Component(modules = [AndroidDependenciesModule::class])
interface ApplicationComponent : ApplicationProvider {

    companion object {

        fun init(app: IdeaApp) : ApplicationProvider {

            val androidDependenciesModule = AndroidDependenciesModule()

            return DaggerApplicationComponent.factory().create(androidDependenciesModule)

        }
    }

    @Component.Factory
    interface Factory {
        fun create(
            androidDependenciesModule: AndroidDependenciesModule
        ): ApplicationComponent
    }


}