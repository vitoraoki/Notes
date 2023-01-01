package com.example.notes.di

import com.example.notes.di.scopes.AppScope
import com.example.notes.presentation.BaseActivity
import com.squareup.anvil.annotations.MergeComponent
import javax.inject.Singleton

@Singleton
@MergeComponent(AppScope::class)
interface AppComponent {

    fun inject(target: BaseActivity)
}