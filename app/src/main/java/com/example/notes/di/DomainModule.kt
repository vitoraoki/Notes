package com.example.notes.di

import com.example.notes.domain.usecase.CreateNote
import com.example.notes.domain.usecase.CreateNoteUseCase
import com.example.notes.domain.usecase.DeleteNote
import com.example.notes.domain.usecase.DeleteNoteUseCase
import com.example.notes.domain.usecase.GetNotes
import com.example.notes.domain.usecase.GetNotesUseCase
import com.example.notes.domain.usecase.SortNotesList
import com.example.notes.domain.usecase.SortNotesListUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class DomainModule {

    @Binds
    abstract fun bindsCreateNoteUseCase(
        useCase: CreateNote
    ): CreateNoteUseCase

    @Binds
    abstract fun bindsDeleteNoteUseCase(
        useCase: DeleteNote
    ): DeleteNoteUseCase

    @Binds
    abstract fun bindsGetNotesUseCase(
        useCase: GetNotes
    ): GetNotesUseCase

    @Binds
    abstract fun bindsSortNotesListUseCase(
        useCase: SortNotesList
    ): SortNotesListUseCase
}