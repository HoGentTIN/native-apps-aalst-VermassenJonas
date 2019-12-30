package com.example.initiativetracker.domain

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class Monster(
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    var name: String,
    var initiative: Int,
    var sessionId: String
)
