package me.test.data.models

import me.test.data.isFavourite
import me.test.roomdb.entity.ProductEntity

data class Product(
    val id: Long,
    val name: String?,
    val brand: String?,
    val price: Long?,
    val description: String?,
    val imageUrl: String?,
    val isFavourite: Boolean?
) {
    fun toEntity(): ProductEntity {
        return ProductEntity(
            id = id,
            name = name,
            brand = brand,
            price = price,
            description = description,
            imageUrl = imageUrl,
            isFavourite = isFavourite?.isFavourite()
        )
    }
}
