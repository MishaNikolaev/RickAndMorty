package com.example.rickandmorty.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.rickandmorty.data.local.entity.HeroEntity

@Dao
interface HeroesDAO {
    @Query("SELECT * FROM heroentity")
    suspend fun getAll(): List<HeroEntity>

    @Query("SELECT * FROM heroentity where id = :id")
    suspend fun getById(id: Int): HeroEntity

    @Query("DELETE FROM heroentity where id = :id")
    suspend fun deleteById(id: Int)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(heroes: List<HeroEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(hero: HeroEntity)

    @Delete
    suspend fun delete(hero: HeroEntity)

    @Update
    suspend fun update(hero: HeroEntity)
}