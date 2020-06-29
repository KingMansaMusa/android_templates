package com.juliuskrah.template.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.juliuskrah.template.data.domain.Item
import java.util.*

@Dao
interface ExampleDao {
    @Query("SELECT * FROM item ORDER BY name DESC")
    fun getItemsOrderByName(): LiveData<List<Item>>

    @Query("SELECT * FROM item WHERE id = :id LIMIT 1")
    fun findOne(id: UUID): LiveData<Item>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOne(item: Item)

    @Insert
    suspend fun insertAll(items: List<Item>)

    @Delete
    suspend fun deleteOne(item: Item)

    @Query("DELETE FROM item")
    suspend fun deleteAll()
}