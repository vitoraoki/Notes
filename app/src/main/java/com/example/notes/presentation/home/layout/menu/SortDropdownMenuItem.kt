package com.example.notes.presentation.home.layout.menu

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.notes.R
import com.example.notes.presentation.model.SortAction
import com.example.notes.presentation.model.SortOrder

@Composable
fun SortDropdownMenuItem(
    sortAction: SortAction,
    onClick: () -> Unit,
) {
    DropdownMenuItem(onClick = onClick) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Text(text = sortAction.value)
            OrderIcon(sortAction.order)
        }
    }
}

@Composable
private fun OrderIcon(sortOrder: SortOrder) {
    when(sortOrder) {
        SortOrder.ASC -> Icon(
            painter = painterResource(R.drawable.ic_arrow_upward),
            contentDescription = stringResource(id = R.string.home_top_bar_sort_asc)
        )
        SortOrder.DESC -> Icon(
            painter = painterResource(R.drawable.ic_arrow_downward),
            contentDescription =stringResource(id = R.string.home_top_bar_sort_desc)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SortMenuItemPreview() {
    SortDropdownMenuItem(
        sortAction = SortAction.SORT_BY_CREATED_AT_DESC,
        onClick = {}
    )
}