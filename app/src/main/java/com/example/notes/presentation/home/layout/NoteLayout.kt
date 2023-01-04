package com.example.notes.presentation.home.layout

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.notes.extensions.tapGestures
import com.example.notes.presentation.home.listener.NoteClickListener
import com.example.notes.presentation.model.NotePriorityUi
import com.example.notes.presentation.model.NoteUiModel
import com.example.notes.ui.theme.NotesTheme
import java.text.SimpleDateFormat
import java.util.*

private const val DATE_FORMAT = "dd/MM/yyyy HH:mm"

@Composable
fun NoteLayout(
    uiModel: NoteUiModel,
    clickListener: NoteClickListener,
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp, vertical = 4.dp)
            .height(70.dp)
            .background(
                color = uiModel.priority.backgroundColor,
                shape = RoundedCornerShape(8.dp),
            )
            .border(
                width = 1.dp,
                color = uiModel.priority.strokeColor,
                shape = RoundedCornerShape(8.dp),
            )
            .tapGestures(
                onClick = {
                    clickListener.onClick(text = uiModel.title)
                },
                onLongClick = {
                    clickListener.onLongClick(text = uiModel.title)
                },
            )
            .padding(10.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Title(title = uiModel.title)
        Details(uiModel = uiModel)
    }
}

@Composable
private fun Title(title: String) {
    Text(
        text = title,
        color = Color.White,
        fontSize = 16.sp,
        fontWeight = FontWeight.Bold
    )
}

@Composable
private fun Details(uiModel: NoteUiModel) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Description(description = uiModel.description)
        NoteDate(date = uiModel.date)
    }
}

@Composable
private fun NoteDate(date: Date) {
    val formattedDate = SimpleDateFormat(DATE_FORMAT, Locale.getDefault()).format(date)

    Text(
        text = formattedDate,
        color = Color.White,
        fontSize = 10.sp
    )
}

@Composable
private fun Description(description: String) {
    Text(
        text = description,
        color = Color.White,
        fontSize = 12.sp
    )
}

@Preview(showBackground = true)
@Composable
fun RowPreview() {
    NotesTheme(darkTheme = true) {
        NoteLayout(
            uiModel = NoteUiModel(
                title = "Note title",
                description = "Note description",
                date = Date(System.currentTimeMillis()),
                priority = NotePriorityUi.High
            ),
            clickListener = object : NoteClickListener {
                override fun onClick(text: String) {}
                override fun onLongClick(text: String) {}
            }
        )
    }
}