package com.juliuskrah.template.ui.one

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.juliuskrah.template.data.repository.ExampleRepository

class OneViewModel @ViewModelInject constructor(
    private val repository: ExampleRepository
) : ViewModel() {

    private val _text = repository.one()
    val text: LiveData<String> = _text
}