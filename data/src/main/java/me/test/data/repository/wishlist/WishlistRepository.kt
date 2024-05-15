package me.test.data.repository.wishlist

import me.test.data.models.Product

interface WishlistRepository {
    suspend fun getWishlists(): List<Product>
    suspend fun addToWishlist(id: Long, isFavourite: Boolean): Product
}