package com.example.notes.presentation.createnote

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.notes.data.model.getPriorityList
import com.example.notes.databinding.FragmentCreateNoteBinding
import com.example.notes.presentation.BaseFragment
import com.example.notes.presentation.createnote.layout.CreateNoteLayout
import com.example.notes.presentation.createnote.listener.CreateNoteClickListener
import com.example.notes.presentation.model.CreateNoteUiModel
import com.example.notes.ui.theme.NotesTheme

class CreateNoteFragment : BaseFragment(), CreateNoteClickListener {

    private lateinit var binding: FragmentCreateNoteBinding
    private val viewModel: CreateNoteViewModel by viewModels { viewModelFactory }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCreateNoteBinding.inflate(inflater, container, false)

        binding.composeView.apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)

            setContent {
                NotesTheme(darkTheme = false) {
                    CreateNoteLayout(
                        priorityOptions = getPriorityList(),
                        listener = this@CreateNoteFragment
                    )
                }
            }
        }

        return binding.root
    }

    override fun onCreateClick(createNoteUiModel: CreateNoteUiModel) {
        val result = viewModel.saveNote(createNoteUiModel)

        setFragmentResult(
            CREATE_NOTE_FRAGMENT_RESULT_KEY,
            bundleOf(CREATE_NOTE_RESULT_KEY to result)
        )
        findNavController().popBackStack()
    }

    override fun onCloseClick() {
        findNavController().popBackStack()
    }

    companion object {
        const val CREATE_NOTE_FRAGMENT_RESULT_KEY = "CREATE_NOTE_FRAGMENT_RESULT_KEY"
        const val CREATE_NOTE_RESULT_KEY = "CREATE_NOTE_RESULT_KEY"
    }
}