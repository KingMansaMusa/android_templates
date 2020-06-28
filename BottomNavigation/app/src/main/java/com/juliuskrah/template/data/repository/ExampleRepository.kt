package com.juliuskrah.template.data.repository

import androidx.lifecycle.LiveData

interface ExampleRepository {
    fun one(): LiveData<String>
    fun two(): LiveData<String>
    fun three(): LiveData<String>
}