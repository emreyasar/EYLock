package com.emreyasar.eylock.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "eylock_user")
data class UserEntity (

    @PrimaryKey(autoGenerate = true)
    var userId: Long = 0L,

    var name: String = "",

    var createdDate: Long = System.currentTimeMillis()
)