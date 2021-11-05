package com.emreyasar.eylock.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "eylock_lock")
data class LockEntity (

    @PrimaryKey(autoGenerate = true)
    var lockId: Long = 0L,

    var name: String = "",

    var createdDate: Long = System.currentTimeMillis()
)