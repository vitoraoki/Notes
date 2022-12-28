package com.example.notes.di

import com.example.notes.domain.GetNotes
import com.example.notes.domain.GetNotesUseCase
import dagger.Binds
import dagger.Module

@Module
abstract class UseCaseModule {

    @Binds
    abstract fun bindGetNotesUseCase(useCase: GetNotes): GetNotesUseCase
}