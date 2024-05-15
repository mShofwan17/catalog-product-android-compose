package me.test.roomdb.di

import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import me.test.roomdb.CatalogProductDatabase

@EntryPoint
@InstallIn(SingletonComponent::class)
interface RoomDependencies {
    fun provideDatabase() : CatalogProductDatabase
}