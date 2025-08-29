package com.maya.app.data

import androidx.room.*

@Entity(tableName = "message")
data class Message(
    val user: String,
    val bot: String,
    val ts: Long,
    @PrimaryKey(autoGenerate = true) val id: Long = 0
)

@Dao
interface MemoryDao {
    @Insert
    suspend fun insert(msg: Message)

    @Query("SELECT * FROM message ORDER BY ts DESC LIMIT 100")
    suspend fun getHistory(): List<Message>
}
