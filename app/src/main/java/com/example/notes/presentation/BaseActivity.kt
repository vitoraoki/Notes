package com.example.notes.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import com.example.notes.application.NotesApplication
import com.example.notes.di.factory.ViewModelFactory
import javax.inject.Inject

open class BaseActivity : ComponentActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (application as NotesApplication).appComponent.inject(this)
    }
}