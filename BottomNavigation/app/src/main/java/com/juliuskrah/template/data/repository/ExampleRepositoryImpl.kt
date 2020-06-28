package com.juliuskrah.template.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import javax.inject.Inject

class ExampleRepositoryImpl @Inject constructor(): ExampleRepository {
    override fun one(): LiveData<String> {
        return MutableLiveData<String>().apply {
            value = "This is first fragment"
        }
    }

    override fun two(): LiveData<String> {
        return MutableLiveData<String>().apply {
            value = "This is second fragment"
        }
    }

    override fun three(): LiveData<String> {
        return MutableLiveData<String>().apply {
            value = "This is third fragment"
        }
    }
}