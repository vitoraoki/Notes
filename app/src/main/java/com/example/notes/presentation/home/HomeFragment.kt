package com.example.notes.presentation.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResultListener
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.notes.R
import com.example.notes.databinding.FragmentHomeBinding
import com.example.notes.extensions.createNoteTransitionAnimation
import com.example.notes.presentation.createnote.CreateNoteFragment
import com.example.notes.presentation.home.layout.NotesScreen
import com.example.notes.presentation.home.listener.HomeClickListener
import com.example.notes.presentation.model.NoteUiModel
import com.example.notes.presentation.model.SortAction
import com.example.notes.ui.theme.NotesTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@AndroidEntryPoint
class HomeFragment : Fragment(), HomeClickListener {

    private val viewModel: HomeViewModel by viewModels()
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
                    NotesTheme(darkTheme = false) {
                        NotesScreen(
                            notes = notes,
                            listener = this@HomeFragment
                        )
                    }
                }
            }.launchIn(lifecycleScope)
        }

        setupResultListener()

        return binding.root
    }

    override fun onResume() {
        super.onResume()
        viewModel.getNotes()
    }

    private fun setupResultListener() {
        setFragmentResultListener(
            CreateNoteFragment.CREATE_NOTE_FRAGMENT_RESULT_KEY
        ) { _, bundle ->
            val result = bundle.getBoolean(CreateNoteFragment.CREATE_NOTE_RESULT_KEY)

            if (result) {
                val message = requireContext().getString(R.string.home_create_note_success_message)
                Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onClick(noteUiModel: NoteUiModel) {
        val text = "Click - ${noteUiModel.title}"
        Toast.makeText(requireContext(), text, Toast.LENGTH_SHORT).show()
    }

    override fun onLongClick(noteUiModel: NoteUiModel) {
        deleteConfirmationDialog { dialog ->
            viewModel.deleteNote(noteUiModel)
            dialog.dismiss()
        }
    }

    override fun onAddClick() {
        val options = createNoteTransitionAnimation()
        findNavController().navigate(R.id.nav_create_note_fragment, null, options)
    }

    override fun onSortClick(sortAction: SortAction) {
        viewModel.sortNotes(sortAction)
    }
}