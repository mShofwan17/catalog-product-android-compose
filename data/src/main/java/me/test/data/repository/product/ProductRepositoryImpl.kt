package me.test.data.repository.product

import me.test.data.dataSource.ProductDataSource
import me.test.data.models.Product
import javax.inject.Inject

class ProductRepositoryImpl @Inject constructor(
    private val dataSource: ProductDataSource
) : ProductRepository {
    override suspend fun getAllProducts(): List<Product> {
        return dataSource.getAllProduct()
    }

    override suspend fun searchProducts(name: String): List<Product> {
        return dataSource.searchProduct(name)
    }

    override suspend fun getDetailProduct(id: Long): Product {
        return dataSource.getDetailProduct(id)
    }
}