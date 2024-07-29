package com.example.notes.di

import com.example.notes.data.repository.NotesRepository
import com.example.notes.data.repository.NotesRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {

    @Binds
    @Singleton
    abstract fun bindsNotesRepository(
        repository: NotesRepositoryImpl
    ): NotesRepository
}