package com.example.notes.utils

interface Mapper<in T, out R>  {
    fun map(it: T): R
}