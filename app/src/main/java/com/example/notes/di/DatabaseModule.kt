package com.example.notes.di

import android.app.Application
import androidx.room.Room
import com.example.notes.data.database.DATABASE_NAME
import com.example.notes.data.database.NotesDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Singleton
    @Provides
    fun provideNotesDataBase(application: Application) =
        Room.databaseBuilder(
            application,
            NotesDataBase::class.java,
            DATABASE_NAME
        ).build()

    @Singleton
    @Provides
    fun provideNotesDao(notesDataBase: NotesDataBase) =
        notesDataBase.notesDao()
}