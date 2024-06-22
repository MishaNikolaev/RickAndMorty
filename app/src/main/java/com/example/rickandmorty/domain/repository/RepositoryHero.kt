package com.example.rickandmorty.domain.repository

import com.example.rickandmorty.domain.model.HeroDataDetails

interface RepositoryHero {
    suspend fun getHeroes():List<HeroDataDetails>
}