package com.example.initiativetracker.ui.MonsterList

import android.app.Application
import androidx.lifecycle.ViewModel
import com.example.initiativetracker.database.Room
import com.example.initiativetracker.domain.Monster
import com.example.initiativetracker.repositories.MonsterRepository
import com.example.initiativetracker.storage.SharedPrefManager
import com.example.initiativetracker.util.App
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import java.io.IOException

class MonsterListViewModel(application: Application) : ViewModel() {

    private val monsterRepository = MonsterRepository(Room.getInstance(application))

    private val viewModelJob = SupervisorJob()

    private val viewModelScope = CoroutineScope(viewModelJob + Dispatchers.Main)

    var monsters =
        monsterRepository.getMonsters(SharedPrefManager.getInstance(App.applicationContext()).session.sessionId)

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

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }

    fun onRefresh() {
        refreshDataFromNetwork()
    }
}
