package me.test.roomdb.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tb_product")
data class ProductEntity(
    @PrimaryKey(autoGenerate = true) val id: Long,
    val name: String?,
    val brand: String?,
    val price: Long?,
    val description: String?,
    val imageUrl: String?,
    val isFavourite: Int?
)
