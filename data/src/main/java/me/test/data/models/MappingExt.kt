package me.test.data.models

import me.test.data.isFavourite
import me.test.roomdb.entity.ProductEntity

fun ProductEntity.toProduct(): Product {
    this.apply {
        return Product(
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