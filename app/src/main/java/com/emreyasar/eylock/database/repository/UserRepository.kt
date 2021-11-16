package com.emreyasar.eylock.database.repository

interface UserRepository {

    fun insertUser(email: String, name: String): Boolean

}