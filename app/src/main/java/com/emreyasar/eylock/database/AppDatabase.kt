package com.emreyasar.eylock.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.emreyasar.eylock.database.dao.LockDAO
import com.emreyasar.eylock.database.dao.UserDAO
import com.emreyasar.eylock.database.entity.LockEntity
import com.emreyasar.eylock.database.entity.LockUserEntity
import com.emreyasar.eylock.database.entity.UserEntity

@Database(entities = [LockEntity::class, UserEntity::class, LockUserEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun lockDao(): LockDAO
    abstract fun userDao(): UserDAO
}