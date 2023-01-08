package com.example.notes.extensions

import androidx.navigation.NavOptions
import androidx.navigation.navOptions
import com.example.notes.R

fun createNoteTransitionAnimation(): NavOptions = navOptions {
    anim {
        enter = R.anim.slide_in
        exit = R.anim.fade_out
        popExit = R.anim.slide_out
        popEnter = R.anim.fade_in
    }
}