package com.example.initiativetracker.network

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object RetrofitClient {
    private const val BASE_URL = "TODO" // TODO

    private val okHttpClient = OkHttpClient.Builder().build()

    val instance: MonsterApi by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .client(okHttpClient)
            .build()
        retrofit.create(MonsterApi::class.java)
    }
}
