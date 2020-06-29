package com.juliuskrah.template.data

import androidx.room.TypeConverter
import java.util.*

class Converters {
    @TypeConverter
    fun uuidToString(uuid: UUID?): String? = uuid?.toString()

    @TypeConverter
    fun stringToUUid(string: String?): UUID? = string?.let { UUID.fromString(it) }
}