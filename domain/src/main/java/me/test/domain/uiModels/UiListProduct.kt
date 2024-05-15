package me.test.domain.uiModels

data class UiListProduct(
    val id: Long,
    val name: String?,
    val brand: String?,
    val price: Long?,
    val imageUrl: String?,
    val isFavourite: Boolean?
)
