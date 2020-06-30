package com.juliuskrah.template.ui.one

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.juliuskrah.template.data.domain.TodoItem
import com.juliuskrah.template.data.repository.ExampleRepository

class OneViewModel @ViewModelInject constructor(
    private val exampleRepository: ExampleRepository
): ViewModel() {

    val items: LiveData<List<TodoItem>> = exampleRepository.items()
}