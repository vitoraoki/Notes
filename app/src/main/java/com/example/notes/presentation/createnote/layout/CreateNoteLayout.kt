package com.example.notes.presentation.createnote.layout

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.notes.R
import com.example.notes.presentation.createnote.listener.OnCreateNoteListener
import com.example.notes.presentation.model.CreateNoteUiModel
import com.example.notes.ui.components.OutlinedDropdown
import com.example.notes.ui.theme.NotesTheme
import java.util.*

@Composable
fun CreateNoteLayout(
    priorityOptions: List<String>,
    listener: OnCreateNoteListener,
) {

    var title by remember {
        mutableStateOf("")
    }

    var description by remember {
        mutableStateOf("")
    }

    var selectedPriority by remember {
        mutableStateOf("")
    }

    var buttonEnabled by remember {
        mutableStateOf(false)
    }

    ScreenLayout {
        Title(
            title = title,
            onValueChanged = {
                title = it
                buttonEnabled = isButtonEnabled(title, description, selectedPriority)
            }
        )
        Spacer(modifier = Modifier.height(12.dp))
        Description(
            description = description,
            onValueChanged = {
                description = it
                buttonEnabled = isButtonEnabled(title, description, selectedPriority)
            }
        )
        Spacer(modifier = Modifier.height(12.dp))
        OutlinedDropdown(
            label = stringResource(id = R.string.create_note_priority_label),
            options = priorityOptions,
            selectedOption = selectedPriority,
            onSelectOption = {
                selectedPriority = it
                buttonEnabled = isButtonEnabled(title, description, selectedPriority)
            }
        )
        Spacer(modifier = Modifier.height(32.dp))
        CreateButton(enabled = buttonEnabled) {
            listener.onCreateClick(
                CreateNoteUiModel(
                    title = title,
                    description = description,
                    priority = selectedPriority,
                    date = Date(System.currentTimeMillis())
                )
            )
        }
    }
}

private fun isButtonEnabled(
    title: String,
    description: String,
    selectedOption: String,
): Boolean = title.isNotEmpty() && description.isNotEmpty() && selectedOption.isNotEmpty()

@Composable
private fun ScreenLayout(content: @Composable () -> Unit) {
    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = stringResource(id = R.string.create_note_top_bar)) })
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(horizontal = 8.dp)
        ) {
            content()
        }
    }
}

@Composable
private fun Title(
    title: String,
    onValueChanged: (String) -> Unit
) {
    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        value = title,
        onValueChange = onValueChanged,
        singleLine = true,
        label = { Text(text = stringResource(id = R.string.create_note_title_label)) }
    )
}

@Composable
private fun Description(
    description: String,
    onValueChanged: (String) -> Unit
) {
    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp),
        value = description,
        onValueChange = onValueChanged,
        label = { Text(text = stringResource(id = R.string.create_note_description_label)) }
    )
}


@Composable
private fun CreateButton(
    enabled: Boolean,
    onClick: () -> Unit
) {
    Button(
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp),
        onClick = onClick,
        enabled = enabled
    ) {
        Text(text = stringResource(id = R.string.create_note_create_button_label))
    }
}

@Preview(showBackground = true)
@Composable
fun CreateNoteLayoutPreview() {
    NotesTheme(darkTheme = false) {
        CreateNoteLayout(
            priorityOptions = listOf("Option 1", "Option 2", "Option 3", "Option 4", "Option 5"),
            listener = object : OnCreateNoteListener {
                override fun onCreateClick(createNoteUiModel: CreateNoteUiModel) {}
            }
        )
    }
}