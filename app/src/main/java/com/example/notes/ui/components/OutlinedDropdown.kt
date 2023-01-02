@file:OptIn(ExperimentalMaterialApi::class)
@file:Suppress("OPT_IN_IS_NOT_ENABLED")

package com.example.notes.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun OutlinedDropdown(
    label: String,
    options: List<String>,
    selectedOption: String,
    onSelectOption: (String) -> Unit,
) {
    var expanded by remember { mutableStateOf(false) }

    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = { expanded = !expanded }
    ) {
        DropdownBox(
            optionSelected = selectedOption,
            label = label,
            expanded = expanded
        )
        DropdownMenu(
            options = options,
            expanded = expanded,
            onDismissRequest = { expanded = false },
            onItemClick = {
                onSelectOption(it)
                expanded = false
            }
        )
    }
}

@Composable
private fun DropdownBox(
    optionSelected: String,
    label: String,
    expanded: Boolean,
) {
    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        readOnly = true,
        value = optionSelected,
        onValueChange = { },
        label = { Text(label) },
        trailingIcon = {
            ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded)
        },
        colors = ExposedDropdownMenuDefaults.textFieldColors(backgroundColor = Color.Transparent)
    )
}

@Composable
private fun ExposedDropdownMenuBoxScope.DropdownMenu(
    options: List<String>,
    expanded: Boolean,
    onDismissRequest: () -> Unit,
    onItemClick: (String) -> Unit,
) {
    ExposedDropdownMenu(
        modifier = Modifier.fillMaxWidth(),
        expanded = expanded,
        onDismissRequest = onDismissRequest
    ) {
        options.forEach { selectedOption ->
            DropdownItem(selectedOption = selectedOption, onItemClick = onItemClick)
        }
    }
}

@Composable
private fun DropdownItem(
    selectedOption: String,
    onItemClick: (String) -> Unit,
) {
    DropdownMenuItem(
        onClick = {
            onItemClick(selectedOption)
        }
    ) {
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = selectedOption
        )
    }
}