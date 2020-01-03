package com.example.initiativetracker.network.dto

import com.example.initiativetracker.domain.Monster
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class MonsterDto(
    val id: Int,
    val name: String,
    val initiative: Int,
    val sessionId: String
) {
    fun toObject(): Monster {
        return Monster(id, name, initiative, sessionId)
    }


}