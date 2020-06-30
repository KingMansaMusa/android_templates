package com.juliuskrah.template.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import com.juliuskrah.template.data.dao.ExampleDao
import com.juliuskrah.template.data.domain.Item
import com.juliuskrah.template.data.domain.TodoItem
import javax.inject.Inject

class ExampleRepositoryImpl @Inject constructor(
    exampleDao: ExampleDao
): ExampleRepository {
    override fun two(): LiveData<String> {
        return MutableLiveData<String>().apply {
            value = "This is second Fragment"
        }
    }

    override fun three(): LiveData<String> {
        return MutableLiveData<String>().apply {
            value = "This is third Fragment"
        }
    }

    override fun items(): LiveData<List<TodoItem>> {
        return Transformations.map(this.items, ::entityToModel)
    }

    private fun entityToModel(items: List<Item>): List<TodoItem> {
        return items.map {
            TodoItem(it.id, it.name, it.description, it.startAt.toInstant().toEpochMilli())
        }
    }

    private val items = exampleDao.getItemsOrderByDate()
}