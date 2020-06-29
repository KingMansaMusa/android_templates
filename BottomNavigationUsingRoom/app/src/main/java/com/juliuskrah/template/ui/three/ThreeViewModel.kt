package com.juliuskrah.template.ui.three

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.juliuskrah.template.data.repository.ExampleRepository

class ThreeViewModel @ViewModelInject constructor(
    private val exampleRepository: ExampleRepository
): ViewModel() {

    val text: LiveData<String> = exampleRepository.three()
}