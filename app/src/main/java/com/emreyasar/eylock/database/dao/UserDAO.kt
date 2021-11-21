package com.emreyasar.eylock.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import com.emreyasar.eylock.database.entity.UserEntity
import com.emreyasar.eylock.database.entity.UserWithLocks
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDAO {

    @Insert
    suspend fun insert(user: UserEntity)

    @Query("SELECT * FROM eylock_user WHERE email = :mail")
    suspend fun getByMail(mail: String) : UserEntity?


    @Query("SELECT * FROM eylock_user ORDER BY createdDate DESC")
    fun getUserList() : List<UserEntity>

    @Transaction
    @Query("SELECT * FROM eylock_user WHERE userId = :userId")
    fun getUserWithLocks(userId: Long): UserWithLocks

}