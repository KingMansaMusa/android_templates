package com.juliuskrah.template.workers

import android.content.Context
import android.util.Log
import androidx.hilt.Assisted
import androidx.hilt.work.WorkerInject
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.juliuskrah.template.data.dao.ExampleDao
import com.juliuskrah.template.data.domain.Item
import kotlinx.coroutines.coroutineScope
import java.util.*

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
            val items = listOf(
                Item(UUID.fromString("3c906c85-ca49-4356-9a3d-6d99c2c45b18"), "Abeiku"),
                Item(UUID.fromString("7386207e-f7f0-4b2c-a9b2-3e3993a2bda9"), "Freda")
            )
            Log.d(TAG, "Saving ${items.joinToString()}")
            exampleDao.insertAll(items)
            Result.success()
        } catch (ex: Exception) {
            Log.e(TAG, "Error seeding database", ex)
            Result.failure()
        }
    }

    companion object {
        private const val TAG = "SeedDatabaseWorker"
    }
}