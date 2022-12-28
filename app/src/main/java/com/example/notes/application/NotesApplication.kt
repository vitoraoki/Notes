package com.example.notes.application

import android.app.Application
import com.example.notes.di.AppComponent
import com.example.notes.di.AppModule
import com.example.notes.di.DaggerAppComponent

class NotesApplication : Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = initAppComponent(this)
    }

    private fun initAppComponent(application: NotesApplication): AppComponent =
        DaggerAppComponent.builder()
            .appModule(AppModule(application))
            .build()
}