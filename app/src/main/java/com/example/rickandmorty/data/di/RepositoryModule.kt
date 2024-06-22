package com.example.rickandmorty.data.di

import com.example.rickandmorty.data.repository.RepositoryImplHero
import com.example.rickandmorty.domain.repository.RepositoryHero
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun bindRepository(
        repositoryImplHero: RepositoryImplHero
    ): RepositoryHero
}