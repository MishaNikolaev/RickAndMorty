package com.example.rickandmorty.data.repository

import android.util.Log
import com.example.rickandmorty.data.local.dao.HeroesDAO
import com.example.rickandmorty.data.local.entity.toHeroDataDetails
import com.example.rickandmorty.data.remote.HeroesApi
import com.example.rickandmorty.data.remote.dto.toHeroEntity
import com.example.rickandmorty.domain.model.HeroDataDetails
import com.example.rickandmorty.domain.repository.RepositoryHero
import javax.inject.Inject

private const val TAG = "RepositoryImplHero"
class RepositoryImplHero @Inject constructor(private val api: HeroesApi, private val heroesDao: HeroesDAO) : RepositoryHero {

    override suspend fun getHeroes(): List<HeroDataDetails> {
        try{
            Log.d(TAG, "getHeroes: 1")
            val response = api.getHeroes(page = 1)
            Log.d(TAG, "getHeroes: ${response}")
            val heroesEntity = response.results.map {
                it.toHeroEntity()
            }
            heroesDao.insertAll(heroes = heroesEntity)
        }
        catch (e: Exception){
            Log.d(TAG, "getHeroes: Error $e")
        }
        val heroesEntity = heroesDao.getAll()

        val heroesDetails = heroesEntity.map {
            it.toHeroDataDetails()
        }
        return heroesDetails
    }
}