package me.test.roomdb

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import me.test.roomdb.dao.ProductDao
import me.test.roomdb.entity.ProductEntity

@Database(
    entities = [
        ProductEntity::class,
    ], version = 1, exportSchema = false
)
abstract class CatalogProductDatabase : RoomDatabase() {
    companion object {
        fun create(context: Context, useInMemory: Boolean): CatalogProductDatabase {
            val dbBuilder =
                if (useInMemory) Room.inMemoryDatabaseBuilder(
                    context,
                    CatalogProductDatabase::class.java
                )
                else Room.databaseBuilder(
                    context,
                    CatalogProductDatabase::class.java,
                    "test_database.db"
                )
            return dbBuilder.fallbackToDestructiveMigration().build()
        }
    }

    abstract fun productDao(): ProductDao
}