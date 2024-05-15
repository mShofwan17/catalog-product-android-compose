package me.test.domain.uiModels

import me.test.data.models.Product

fun Product.toListProduct(): UiListProduct {
    this.apply {
        return UiListProduct(
            id = id,
            name = name,
            brand = brand,
            price = price,
            imageUrl = imageUrl,
            isFavourite = isFavourite
        )
    }
}

fun Product.toDetailProduct(): UiDetailProduct {
    this.apply {
        return UiDetailProduct(
            id = id,
            name = name,
            brand = brand,
            price = price,
            description = description,
            imageUrl = imageUrl,
            isFavourite = isFavourite
        )
    }
}