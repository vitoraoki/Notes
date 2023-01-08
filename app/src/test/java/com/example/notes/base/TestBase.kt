package com.example.notes.base

open class TestBase {

    fun randomBoolean(): Boolean = listOf(true, false).random()

    inline fun <reified T: Enum<T>> randomEnum(): T =
        T::class.java.enumConstants!!.random()
}