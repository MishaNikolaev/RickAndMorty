package com.example.rickandmorty.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.rickandmorty.domain.model.HeroDataDetails

@Entity
data class HeroEntity(
    @PrimaryKey(autoGenerate = false)
    val name: String,
    val gender: String,
    val id: Int
)

fun HeroEntity.toHeroDataDetails(): HeroDataDetails {
    return HeroDataDetails(
        name = name,
        gender = gender,
        id = id
    )
}