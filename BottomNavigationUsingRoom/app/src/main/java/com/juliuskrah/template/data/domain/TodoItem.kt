package com.juliuskrah.template.data.domain

import java.util.*

data class TodoItem(
    val id: UUID,
    val name: String,
    val description: String,
    val startAt: Long
)