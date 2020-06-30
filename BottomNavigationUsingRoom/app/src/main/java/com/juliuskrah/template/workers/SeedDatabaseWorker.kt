package com.juliuskrah.template.workers

import android.content.Context
import android.util.Log
import androidx.hilt.Assisted
import androidx.hilt.work.WorkerInject
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.google.gson.stream.JsonReader
import com.juliuskrah.template.data.dao.ExampleDao
import com.juliuskrah.template.data.domain.Item
import com.juliuskrah.template.data.domain.TodoItem
import kotlinx.coroutines.coroutineScope
import org.threeten.bp.Instant
import org.threeten.bp.OffsetDateTime
import org.threeten.bp.ZoneOffset

/**
 * Enable injection @{link @WorkerInject} with the following dependency androidx.hilt:hilt-work
 * You'll need to prevent WorkManager initialization
 * @see <a href="https://developer.android.com/topic/libraries/architecture/workmanager/advanced/custom-configuration">here</a>
 */
class SeedDatabaseWorker  @WorkerInject constructor(
    @Assisted context: Context,
    @Assisted workerParams: WorkerParameters,
    private val exampleDao: ExampleDao
) : CoroutineWorker(context, workerParams) {
    override suspend fun doWork(): Result = coroutineScope {
        try {
            applicationContext.assets.open(TODO_FILENAME).use {inputStream ->
                JsonReader(inputStream.reader()).use {jsonReader ->
                    val itemType = object : TypeToken<List<TodoItem>>() {}.type
                    val itemList: List<TodoItem> = Gson().fromJson(jsonReader, itemType)
                    val items = itemList.map(::mapToDomain)
                    Log.d(TAG, "Saving ${items.joinToString()}")
                    exampleDao.insertAll(items)
                    Result.success()
                }
            }
        } catch (ex: Exception) {
            Log.e(TAG, "Error seeding database", ex)
            Result.failure()
        }
    }

    private fun mapToDomain(todo: TodoItem): Item {
        return Item(todo.id, todo.name, todo.description, fromMillis(todo.startAt))
    }

    companion object {
        private const val TAG = "SeedDatabaseWorker"
        const val TODO_FILENAME = "items.json"
        fun fromMillis(epochMillis: Long): OffsetDateTime {
            return OffsetDateTime.ofInstant(Instant.ofEpochMilli(epochMillis), ZoneOffset.UTC)
        }
    }
}