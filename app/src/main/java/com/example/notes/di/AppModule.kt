package com.example.notes.di

import android.app.Application
import android.content.Context
import com.example.notes.di.scopes.AppScope
import com.squareup.anvil.annotations.ContributesTo
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
@ContributesTo(AppScope::class)
class AppModule(private val application: Application) {

    @Provides
    @Singleton
    fun provideContext(): Context = application
}