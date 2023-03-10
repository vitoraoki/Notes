package com.example.notes.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.notes.application.NotesApplication
import com.example.notes.di.factory.ViewModelFactory
import javax.inject.Inject

open class BaseFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (requireActivity().application as NotesApplication).appComponent.inject(this)
    }
}