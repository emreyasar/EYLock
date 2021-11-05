package com.emreyasar.eylock.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import com.emreyasar.eylock.database.entity.UserEntity
import com.emreyasar.eylock.database.entity.UserWithLocks

@Dao
interface UserDAO {

    @Insert
    fun insert(user: UserEntity)

    @Query("SELECT * FROM eylock_user WHERE userId = :id")
    fun getById(id: Long) : UserEntity?

    @Transaction
    @Query("SELECT * FROM eylock_user WHERE userId = :userId")
    fun getUserWithLocks(userId: Long): List<UserWithLocks>

}