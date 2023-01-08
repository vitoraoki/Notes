package com.example.notes.di

import android.content.Context
import androidx.room.Room
import com.example.notes.data.database.DATABASE_NAME
import com.example.notes.data.database.NotesDataBase
import com.example.notes.di.scopes.AppScope
import com.squareup.anvil.annotations.ContributesTo
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
@ContributesTo(AppScope::class)
class DatabaseModule {

    @Singleton
    @Provides
    fun provideNotesDataBase(context: Context) =
        Room.databaseBuilder(
            context.applicationContext,
            NotesDataBase::class.java,
            DATABASE_NAME
        ).build()

    @Singleton
    @Provides
    fun provideNotesDao(notesDataBase: NotesDataBase) =
        notesDataBase.notesDao()
}