package com.emreyasar.eylock.database.repository

import com.emreyasar.eylock.database.dao.UserDAO
import com.emreyasar.eylock.database.entity.UserEntity
import javax.inject.Inject

class UserRepositoryImpl @Inject internal constructor(private val userDao: UserDAO) : UserRepository {

    override fun insertUser(email: String, name: String): Boolean {
        val userEntity = UserEntity(email = email, name = name)
        return try {
            userDao.insert(userEntity)
            true
        } catch (e: Exception) {
            false
        }

    }
}