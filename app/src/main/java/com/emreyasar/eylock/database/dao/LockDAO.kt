package com.emreyasar.eylock.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import com.emreyasar.eylock.database.entity.LockEntity
import com.emreyasar.eylock.database.entity.LockWithUsers

@Dao
interface LockDAO {

    @Insert
    fun insert(lock: LockEntity)

    @Query("SELECT * FROM eylock_lock WHERE lockId = :id")
    fun getById(id: Long) : LockEntity?

    @Transaction
    @Query("SELECT * FROM eylock_lock WHERE lockId = :lockId")
    fun getLockWithUsers(lockId: Long): List<LockWithUsers>


}