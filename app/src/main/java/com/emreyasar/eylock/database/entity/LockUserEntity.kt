package com.emreyasar.eylock.database.entity

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.Junction
import androidx.room.Relation

@Entity(tableName = "eylock_lock_user", primaryKeys = ["lockId", "userId"])
data class LockUserEntity (
    val lockId: Long,
    val userId: Long
)

data class UserWithLocks(
    @Embedded val user: UserEntity,
    @Relation(
        parentColumn = "userId",
        entityColumn = "lockId",
        associateBy = Junction(LockUserEntity::class, parentColumn = "userId", entityColumn = "lockId")
    )
    val locks: List<LockEntity>
)

data class LockWithUsers(
    @Embedded val lock: LockEntity,
    @Relation(
        parentColumn = "lockId",
        entityColumn = "userId",
        associateBy = Junction(LockUserEntity::class)
    )
    val users: List<UserEntity>
)
