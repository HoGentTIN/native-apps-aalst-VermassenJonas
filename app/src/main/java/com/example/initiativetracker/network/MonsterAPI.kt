package com.example.initiativetracker.network

import retrofit2.http.GET
import retrofit2.http.Path

interface MonsterAPI {
    @GET("/monsters/{session}")
    fun getMonstersForSession(@Path("session") session: String)
}
