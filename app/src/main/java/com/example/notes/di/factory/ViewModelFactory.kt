package com.example.notes.di.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.notes.di.scopes.AppScope
import com.squareup.anvil.annotations.ContributesBinding
import javax.inject.Inject
import javax.inject.Provider
import javax.inject.Singleton

private const val EXCEPTION_MESSAGE = "unknown model class "

@Suppress("UNCHECKED_CAST")
@Singleton
@ContributesBinding(AppScope::class)
class ViewModelFactory @Inject constructor(
    private val creators: MutableMap<Class<out ViewModel>, @JvmSuppressWildcards Provider<ViewModel>>
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val creator: Provider<ViewModel> = getCreatorOrThrowException(creators, modelClass)

        return try {
            creator.get() as T
        } catch (exception: Exception) {
            throw RuntimeException(exception)
        }
    }

    private fun <T : ViewModel> getCreatorOrThrowException(
        creators: MutableMap<Class<out ViewModel>, @JvmSuppressWildcards Provider<ViewModel>>,
        modelClass: Class<T>,
    ): Provider<ViewModel> = creators[modelClass]
        ?: getCreatorOrNull(creators, modelClass)
        ?: throw IllegalArgumentException("$EXCEPTION_MESSAGE $modelClass")

    private fun <T : ViewModel> getCreatorOrNull(
        creators: MutableMap<Class<out ViewModel>, @JvmSuppressWildcards Provider<ViewModel>>,
        modelClass: Class<T>,
    ): Provider<ViewModel>? = creators.entries.firstOrNull {
        modelClass.isAssignableFrom(it.key)
    }?.value
}