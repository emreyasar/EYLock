package com.emreyasar.eylock.database.entity

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(tableName = "eylock_user_event", indices = [Index(value = ["email"], unique = true)])
data class EventEntity (

    @PrimaryKey(autoGenerate = true)
    var eventId: Long = 0L,

    var name: String = "",

    var email: String = "",

    var createdDate: Long = System.currentTimeMillis()
)