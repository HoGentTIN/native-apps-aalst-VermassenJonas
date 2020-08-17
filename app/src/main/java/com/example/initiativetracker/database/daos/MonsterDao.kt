package com.example.initiativetracker.database.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.initiativetracker.domain.Monster

@Dao
interface MonsterDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(monsters: List<Monster>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(monster: Monster)

    @Query("SELECT * FROM Monster ORDER BY id DESC")
    fun getAll(): LiveData<List<Monster>>

    @Query("SELECT * FROM Monster WHERE sessionId = :sessionId ORDER BY turnOrder ASC")
    fun getForSession(sessionId: String): LiveData<List<Monster>>

    @Query("SELECT * FROM Monster WHERE id = :id")
    fun getOne(id: Int): Monster?

    @Query("DELETE FROM Monster")
    fun clear()
}
