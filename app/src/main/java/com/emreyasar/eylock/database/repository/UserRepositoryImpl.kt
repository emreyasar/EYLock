package com.emreyasar.eylock.database.repository

import com.emreyasar.eylock.database.dao.UserDAO
import com.emreyasar.eylock.database.entity.UserEntity
import com.emreyasar.eylock.database.entity.UserWithLocks
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class UserRepositoryImpl @Inject internal constructor(private val userDao: UserDAO) : UserRepository {

    override suspend fun insertUser(email: String, name: String): Boolean {
        val userEntity = UserEntity(email = email, name = name)
        return try {
            userDao.insert(userEntity)
            true
        } catch (e: Exception) {
            false
        }
    }

    override fun getUserList(): Flow<List<UserEntity>> {
        return userDao.getUserList()
    }

    override suspend fun getUserByMail(mail: String): UserEntity? {
        return userDao.getByMail(mail)
    }

    override suspend fun getUserWithLocks(userId: Long): UserWithLocks {
        return userDao.getUserWithLocks(userId)
    }
}