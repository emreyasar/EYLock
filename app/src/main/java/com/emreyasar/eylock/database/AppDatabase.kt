package com.emreyasar.eylock.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
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

    companion object {
        var INSTANCE: AppDatabase? = null

        fun getAppDataBase(context: Context): AppDatabase? {
            if (INSTANCE == null){
                synchronized(AppDatabase::class){
                    INSTANCE = Room.databaseBuilder(context.applicationContext, AppDatabase::class.java, "myDB").build()
                }
            }
            return INSTANCE
        }

        fun destroyDataBase(){
            INSTANCE = null
        }
    }
}