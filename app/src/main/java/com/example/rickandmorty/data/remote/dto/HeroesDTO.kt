package com.example.rickandmorty.data.remote.dto

import com.example.rickandmorty.data.local.entity.HeroEntity
import com.example.rickandmorty.domain.model.HeroDataDetails
import com.google.gson.annotations.SerializedName

data class HeroesAllDto(
    val results: List<HeroesDataDetailsDto>
)

data class HeroesDataDetailsDto(
    val name: String,
    val id: Int,
    val gender: String,

)

fun HeroesDataDetailsDto.toHeroDataDetail(): HeroDataDetails {
    return HeroDataDetails (name = name, gender = gender, id = id)
}

fun HeroesDataDetailsDto.toHeroEntity(): HeroEntity {
    return HeroEntity(name = name, gender = gender, id = id)
}