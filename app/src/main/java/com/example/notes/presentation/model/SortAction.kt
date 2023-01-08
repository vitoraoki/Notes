package com.example.notes.presentation.model

enum class SortAction(val value: String, val order: SortOrder) {
    SORT_BY_CREATED_AT_ASC("Created at", SortOrder.ASC),
    SORT_BY_CREATED_AT_DESC("Created at", SortOrder.DESC),
    SORT_BY_TITLE_ASC("Title", SortOrder.ASC),
    SORT_BY_TITLE_DESC("Title", SortOrder.DESC);
}

enum class SortOrder {
    ASC,
    DESC;
}