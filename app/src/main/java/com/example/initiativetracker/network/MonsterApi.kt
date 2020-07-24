package com.example.initiativetracker.network

import com.example.initiativetracker.domain.Monster
import com.example.initiativetracker.domain.Session
import com.example.initiativetracker.network.dto.MonsterDto
import kotlinx.coroutines.Deferred
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface MonsterApi {
    @GET("monster/{session_code}")
    fun getMonstersForSessionAsync(@Path("session_code") session: String): Deferred<Array<Monster>>

    @POST("monster/{master_code}")
    fun postNewMonster(@Path("master_code") masterCode: String, @Body monster: MonsterDto)

    @DELETE("monster/{master_code}")
    fun deleteMonster(@Path("master_code") masterCode: String, @Body monster: MonsterDto)

    @POST("session")
    fun getNewSessionCodeAsync(): Deferred<Session>
}
