package com.example.initiativetracker.repositories

import androidx.lifecycle.LiveData
import com.example.initiativetracker.database.Room
import com.example.initiativetracker.domain.Monster
import com.example.initiativetracker.network.RetrofitClient
import com.example.initiativetracker.storage.SharedPrefManager
import com.example.initiativetracker.util.App

class MonsterRepository(private val database: Room) {

    val monsters = database.monsterDao.getAll()

    suspend fun refreshMonsters() {
        val monsters = RetrofitClient.instance.getMonstersForSessionAsync(
            SharedPrefManager.getInstance(
                App.applicationContext()
            ).session.sessionId
        ).await()
        database.monsterDao.insert(monsters.toObject())
    }

    fun getMonsters(sessionId: String): LiveData<List<Monster>> {
        return database.monsterDao.getForSession(sessionId)
    }

    fun getAllMonsters(sessionId: String): LiveData<List<Monster>> {
        return database.monsterDao.getAll()
    }

    fun getOne(monsterId: Int): Monster? {
        return database.monsterDao.getOne(monsterId)
    }
}
