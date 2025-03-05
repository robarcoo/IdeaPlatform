package com.example.feature.di

import android.content.Context
import com.example.core.database.ItemDatabase
import com.example.core.di.room.DaggerDatabaseComponent
import dagger.BindsInstance
import dagger.Component
import javax.inject.Scope

@RepositoryScope
@Component(modules = [UseCaseModule::class])
abstract class RepositoryComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun context(context: Context): Builder
        fun build(): RepositoryComponent
    }

    companion object {

        @Suppress("MemberNameEqualsClassName")
        @Volatile
        private var repositoryComponent: RepositoryComponent? = null

        @Synchronized
        fun init(context: Context): RepositoryComponent {
            if (repositoryComponent == null) {
                repositoryComponent = DaggerRepositoryComponent.builder()
                    .context(context)
                    .build()
            }
            return repositoryComponent!!
        }
    }

}

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class RepositoryScope