package com.example.initiativetracker.network

import com.example.initiativetracker.domain.Monster
import kotlinx.coroutines.Deferred
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface MonsterApi {
    @GET("/monsters/{session}")
    fun getMonstersForSessionAsync(@Path("session") session: String): Deferred<List<Monster>>

    @POST("/monsters/{session}")
    fun postUpdatedMonsterListAsync(@Path("session") session: String, @Body monsters: List<Monster>)

    @GET("/session")
    fun getNewSessionCodeAsync(): Deferred<String>
}
