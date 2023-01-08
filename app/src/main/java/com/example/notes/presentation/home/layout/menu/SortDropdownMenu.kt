package com.example.notes.presentation.home.layout.menu

import androidx.compose.foundation.layout.width
import androidx.compose.material.DropdownMenu
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.notes.R
import com.example.notes.presentation.home.listener.HomeClickListener
import com.example.notes.presentation.model.SortAction

@Composable
fun SortDropdownMenu(listener: HomeClickListener) {

    var expanded by remember {
        mutableStateOf(false)
    }

    SortIconButton {
        expanded = true
    }
    DropdownMenu(
        modifier = Modifier.width(150.dp),
        expanded = expanded,
        onDismissRequest = { expanded = false }
    ) {
        SortAction.values().forEach { sortAction ->
            SortDropdownMenuItem(
                sortAction = sortAction,
                onClick = {
                    expanded = false
                    listener.onSortClick(sortAction)
                },
            )
        }
    }
}

@Composable
private fun SortIconButton(onClick: () -> Unit) {
    IconButton(onClick = onClick) {
        Icon(
            painter = painterResource(id = R.drawable.ic_sort),
            contentDescription = stringResource(
                id = R.string.home_top_bar_sort_description
            )
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SortDropdownMenuPreview() {
    SortDropdownMenu(
        listener = object : HomeClickListener {
            override fun onAddClick() {}
            override fun onSortClick(sortAction: SortAction) {}
            override fun onClick(text: String) {}
            override fun onLongClick(text: String) {}
        }
    )
}