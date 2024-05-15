package me.test.roomdb.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import me.test.roomdb.CatalogProductDatabase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {
    @Provides
    @Singleton
    fun provideRoomDb(
        @ApplicationContext context: Context
    ): CatalogProductDatabase {
        return Room.databaseBuilder(
            context = context,
            CatalogProductDatabase::class.java,
            name = "db_catalog_product"
        ).build()
    }
}