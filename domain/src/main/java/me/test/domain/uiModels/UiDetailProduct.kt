package me.test.domain.uiModels

data class UiDetailProduct(
    val id: Long,
    val name: String?,
    val brand: String?,
    val price: Long?,
    val description: String?,
    val imageUrl: String?,
    val isFavourite: Boolean?
)
