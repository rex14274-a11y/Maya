package com.maya.app.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [Message::class],
    version = 1,
    exportSchema = false
)
abstract class MemoryDb : RoomDatabase() {
    abstract fun dao(): MemoryDao
}
