package com.example.initiativetracker.ui.MonsterList

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.initiativetracker.database.Room
import com.example.initiativetracker.domain.Monster
import com.example.initiativetracker.repositories.MonsterRepository
import java.io.IOException
import kotlinx.coroutines.launch

class MonsterListViewModel(application: Application) : ViewModel() {

    private val monsterRepository = MonsterRepository(Room.getInstance(application))

    var monsters = monsterRepository.getMonsters("XXXX") // TODO: handle session

    init {
        refreshDataFromNetwork()
    }

    private fun refreshDataFromNetwork() = viewModelScope.launch {
        try {
            monsterRepository.refreshMonsters()
        } catch (e: IOException) {
            // TODO: error handling
        }
    }

    fun onSetMonster(monster: Monster) {
        TODO("not implemented") // To change body of created functions use File | Settings | File Templates.
    }
}
