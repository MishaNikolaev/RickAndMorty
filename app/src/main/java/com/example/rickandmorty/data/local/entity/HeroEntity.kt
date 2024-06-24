package com.example.rickandmorty.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.rickandmorty.domain.model.HeroDataDetails

@Entity
data class HeroEntity(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val name: String,
    val gender: String,
)

fun HeroEntity.toHeroDataDetails(): HeroDataDetails {
    return HeroDataDetails(
        name = name,
        gender = gender,
        id = id
    )
}