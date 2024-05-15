package me.test.data.repository.wishlist

import me.test.data.dataSource.ProductDataSource
import me.test.data.models.Product
import javax.inject.Inject

class WishlistRepositoryImpl @Inject constructor(
    private val dataSource: ProductDataSource
) : WishlistRepository {
    override suspend fun getWishlists(): List<Product> {
        return dataSource.getProductWishlist()
    }

    override suspend fun addToWishlist(id: Long, isFavourite: Boolean): Product {
        val getProduct = dataSource.getDetailProduct(id).copy(isFavourite = isFavourite)
        return dataSource.updateProduct(getProduct)

    }
}