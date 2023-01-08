package com.example.notes.presentation.createnote

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.notes.databinding.FragmentCreateNoteBinding
import com.example.notes.domain.model.NotePriority
import com.example.notes.presentation.BaseFragment
import com.example.notes.presentation.createnote.layout.CreateNoteLayout
import com.example.notes.presentation.createnote.listener.CreateNoteClickListener
import com.example.notes.presentation.model.CreateNoteUiModel
import com.example.notes.ui.theme.NotesTheme
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

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
                        priorityOptions = NotePriority.getPriorities().map { it.name },
                        listener = this@CreateNoteFragment
                    )
                }
            }
        }

        setupObservers()

        return binding.root
    }

    override fun onCreateClick(createNoteUiModel: CreateNoteUiModel) {
        viewModel.createNote(createNoteUiModel)
    }

    override fun onCloseClick() {
        findNavController().popBackStack()
    }

    private fun setupObservers() {
        viewModel.saveNoteResult.onEach { result ->
            setResultAndClose(result)
        }.launchIn(lifecycleScope)
    }

    private fun setResultAndClose(result: Boolean) {
        setFragmentResult(
            CREATE_NOTE_FRAGMENT_RESULT_KEY,
            bundleOf(CREATE_NOTE_RESULT_KEY to result)
        )
        findNavController().popBackStack()
    }

    companion object {
        const val CREATE_NOTE_FRAGMENT_RESULT_KEY = "CREATE_NOTE_FRAGMENT_RESULT_KEY"
        const val CREATE_NOTE_RESULT_KEY = "CREATE_NOTE_RESULT_KEY"
    }
}