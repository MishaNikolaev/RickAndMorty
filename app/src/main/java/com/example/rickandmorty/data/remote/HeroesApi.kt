package com.example.rickandmorty.data.remote

import com.example.rickandmorty.data.remote.dto.HeroesAllDto
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface HeroesApi {
    @GET("/api/character/")
    suspend fun getHeroes(
        @Query("page") page:Int
    ): HeroesAllDto
}

object RetrofitInstanceHero {
    val api: HeroesApi by lazy {
        Retrofit.Builder()
            .baseUrl("https://rickandmortyapi.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(HeroesApi::class.java)
    }
}