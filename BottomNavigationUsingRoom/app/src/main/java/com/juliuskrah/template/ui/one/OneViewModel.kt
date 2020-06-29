package com.juliuskrah.template.ui.one

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.juliuskrah.template.data.domain.ItemModel
import com.juliuskrah.template.data.repository.ExampleRepository

class OneViewModel @ViewModelInject constructor(
    private val exampleRepository: ExampleRepository
): ViewModel() {

    val items: LiveData<List<ItemModel>> = exampleRepository.items()
}