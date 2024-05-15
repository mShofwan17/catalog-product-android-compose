package me.test.data.repository.product

import me.test.data.models.Product

interface ProductRepository {
    suspend fun getAllProducts(): List<Product>
    suspend fun searchProducts(name: String): List<Product>
    suspend fun getDetailProduct(id: Long): Product
}