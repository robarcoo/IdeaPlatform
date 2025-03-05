package com.example.core.di.room

import android.content.Context
import com.example.core.database.ItemDatabase
import dagger.BindsInstance
import dagger.Component
import javax.inject.Scope
import javax.inject.Singleton

@Singleton
@Component(modules = [RoomModule::class])
abstract class DatabaseComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun context(context: Context): Builder
        fun build(): DatabaseComponent
    }

    companion object {

        @Suppress("MemberNameEqualsClassName")
        @Volatile
        private var databaseComponent: DatabaseComponent? = null

        @Synchronized
        fun init(context: Context): DatabaseComponent {
            if (databaseComponent == null) {
                databaseComponent = DaggerDatabaseComponent.builder()
                    .context(context)
                    .build()
            }
            return databaseComponent!!
        }
    }
    abstract fun itemDatabase(): ItemDatabase

}

