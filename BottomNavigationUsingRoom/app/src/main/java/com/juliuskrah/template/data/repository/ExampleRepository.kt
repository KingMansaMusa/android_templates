package com.juliuskrah.template.data.repository

import androidx.lifecycle.LiveData
import com.juliuskrah.template.data.domain.ItemModel

interface ExampleRepository {
    fun two(): LiveData<String>
    fun three(): LiveData<String>
    fun items(): LiveData<List<ItemModel>>
}