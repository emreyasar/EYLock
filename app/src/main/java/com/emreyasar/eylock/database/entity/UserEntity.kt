package com.emreyasar.eylock.database.entity

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(tableName = "eylock_user", indices = [Index(value = ["email"], unique = true)])
data class UserEntity (

    @PrimaryKey(autoGenerate = true)
    var userId: Long = 0L,

    var name: String = "",

    var email: String = "",

    var createdDate: Long = System.currentTimeMillis()
)