package com.juliuskrah.template.ui.two

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.juliuskrah.template.data.repository.ExampleRepository

class TwoViewModel @ViewModelInject constructor(
    private val exampleRepository: ExampleRepository
) : ViewModel() {

    val text: LiveData<String> = exampleRepository.two()
}