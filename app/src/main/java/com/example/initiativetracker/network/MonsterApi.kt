package com.example.initiativetracker.network

import com.example.initiativetracker.network.dto.MonsterListDto
import kotlinx.coroutines.Deferred
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface MonsterApi {
    @GET("monster/{session}")
    fun getMonstersForSessionAsync(@Path("session") session: String): Deferred<MonsterListDto>

    @POST("monster/{session}")
    fun postUpdatedMonsterListAsync(@Path("session") session: String, @Body monsters: MonsterListDto)

    @GET("session")
    fun getNewSessionCodeAsync(): Deferred<String>
}
