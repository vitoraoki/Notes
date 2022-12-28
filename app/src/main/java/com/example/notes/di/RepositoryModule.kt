package com.example.notes.di

import com.example.notes.data.repository.NotesRepository
import com.example.notes.data.repository.NotesRepositoryImpl
import dagger.Binds
import dagger.Module

@Module
abstract class RepositoryModule {

    @Binds
    abstract fun bindNotesRepository(repository: NotesRepositoryImpl): NotesRepository
}