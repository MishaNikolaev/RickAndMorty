package com.example.rickandmorty.data.di

import android.app.Application
import androidx.room.Room
import com.example.rickandmorty.data.local.AppDatabase
import com.example.rickandmorty.data.local.dao.HeroesDAO
import com.example.rickandmorty.data.remote.HeroesApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideRetrofit(app: Application): HeroesApi {
        return Retrofit.Builder()
            .baseUrl("https://rickandmortyapi.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build().create()
    }
    @Provides
    @Singleton
    fun provideAppDatabase(app: Application): AppDatabase {
        return Room.databaseBuilder(
            app,
            AppDatabase::class.java,
            "heroesDb.db"
        ).build()
    }

    @Provides
    @Singleton
    fun provideDao(db:AppDatabase): HeroesDAO {
        return db.heroDao()
    }

}