package com.juliuskrah.template.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import com.juliuskrah.template.data.dao.ExampleDao
import com.juliuskrah.template.data.domain.Item
import com.juliuskrah.template.data.domain.ItemModel
import javax.inject.Inject

class ExampleRepositoryImpl @Inject constructor(
    private val exampleDao: ExampleDao
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

    override fun items(): LiveData<List<ItemModel>> {
        return Transformations.map(this.items, ::entityToModel)
    }

    private fun entityToModel(items: List<Item>): List<ItemModel> {
        val itemModels = mutableListOf<ItemModel>()
        for(item in items) {
            itemModels.add(ItemModel(item.id, item.name))
        }
        return itemModels
    }

    private val items = exampleDao.getItemsOrderByName()
}