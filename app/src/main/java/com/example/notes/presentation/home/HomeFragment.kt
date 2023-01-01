package com.example.notes.presentation.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.notes.NoteClickListener
import com.example.notes.databinding.FragmentHomeBinding
import com.example.notes.presentation.BaseFragment
import com.example.notes.presentation.ui.layout.NotesList
import com.example.notes.ui.theme.NotesTheme
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class HomeFragment : BaseFragment(), NoteClickListener {

    private val viewModel: HomeViewModel by viewModels { viewModelFactory }
    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        binding.composeView.apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)

            viewModel.notesFlow.onEach { notes ->
                setContent {
                    NotesTheme {
                        NotesList(
                            notes = notes,
                            listener = this@HomeFragment
                        )
                    }
                }
            }.launchIn(lifecycleScope)
        }

        return binding.root
    }

    override fun onClick(text: String) {
        Toast.makeText(requireContext(), "Click - $text", Toast.LENGTH_SHORT).show()
    }

    override fun onLongClick(text: String) {
        Toast.makeText(requireContext(), "Long Click - $text", Toast.LENGTH_SHORT).show()
    }
}