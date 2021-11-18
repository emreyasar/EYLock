package com.emreyasar.eylock.database.repository

import com.emreyasar.eylock.database.entity.UserEntity
import com.emreyasar.eylock.database.entity.UserWithLocks
import kotlinx.coroutines.flow.Flow

interface UserRepository {

    suspend fun insertUser(email: String, name: String): Boolean

    fun getUserList(): Flow<List<UserEntity>>

    suspend fun getUserByMail(mail: String): UserEntity?

    suspend fun getUserWithLocks(userId: Long): UserWithLocks

}