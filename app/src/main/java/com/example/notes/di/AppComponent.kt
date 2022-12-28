package com.example.notes.di

import com.example.notes.presentation.BaseActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        RepositoryModule::class,
        UseCaseModule::class,
        ViewModelModule::class,
    ]
)
interface AppComponent {

    fun inject(target: BaseActivity)
}