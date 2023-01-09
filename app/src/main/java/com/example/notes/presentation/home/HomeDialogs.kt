package com.example.notes.presentation.home

import android.content.DialogInterface
import androidx.appcompat.app.AlertDialog
import com.example.notes.R

fun HomeFragment.deleteConfirmationDialog(positiveClick: (DialogInterface) -> Unit = {}) {
    activity?.let {
        AlertDialog.Builder(it).apply {
            setTitle(R.string.home_delete_note_dialog_title)
            setPositiveButton(R.string.home_delete_note_dialog_positive_button) { dialog, _ ->
                positiveClick(dialog)
            }
            setNegativeButton(R.string.home_delete_note_dialog_negative_button) { dialog, _ ->
                dialog.dismiss()
            }
        }.create().show()
    }
}