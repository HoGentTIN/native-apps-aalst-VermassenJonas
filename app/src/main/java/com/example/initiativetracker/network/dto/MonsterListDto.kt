package com.example.initiativetracker.network.dto

import com.example.initiativetracker.domain.Monster
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class MonsterListDto(val monsters: List<MonsterDto>) {

    fun toObject(): List<Monster> {
        return monsters.map { monsterDto -> monsterDto.toObject() }
    }
}
