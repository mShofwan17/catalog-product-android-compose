package me.test.data.dataSource

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking
import me.test.data.utils.jsonProducts
import me.test.data.models.Product
import me.test.data.models.toProduct
import me.test.roomdb.CatalogProductDatabase
import me.test.roomdb.entity.ProductEntity
import javax.inject.Inject

class ProductDataSource @Inject constructor(
    private val dbSource: CatalogProductDatabase
) : BaseDateSource() {

    suspend fun importProduct() = runBlocking {
        validateResponse {
            val listType = object : TypeToken<List<ProductEntity>>() {}.type
            val items: List<ProductEntity> = Gson().fromJson(jsonProducts, listType)
            dbSource.productDao().add(items)
        }
    }

    suspend fun getAllProduct(): List<Product> = runBlocking {
        return@runBlocking validateResponse {
            var items = async { dbSource.productDao().getAll() }.await()
            if (items.isEmpty()) {
                val listType = object : TypeToken<List<ProductEntity>>() {}.type
                items = Gson().fromJson(jsonProducts, listType)
                dbSource.productDao().add(items)
            }
            items.map { it.toProduct() }
        }
    }

    suspend fun updateProduct(product: Product): Product = runBlocking {
        return@runBlocking validateResponse {
            async { dbSource.productDao().update(product.toEntity()) }.await()
            async { dbSource.productDao().getDetailProduct(product.id).toProduct() }.await()
        }
    }

    suspend fun searchProduct(name: String): List<Product> = runBlocking {
        return@runBlocking validateResponse {
            val items = async { dbSource.productDao().searchProducts(name) }.await()
            items.map { it.toProduct() }
        }
    }

    suspend fun getDetailProduct(id: Long): Product = runBlocking {
        return@runBlocking validateResponse {
            val item = async { dbSource.productDao().getDetailProduct(id) }.await()
            item.toProduct()
        }
    }

    suspend fun getProductWishlist(): List<Product> = runBlocking {
        return@runBlocking validateResponse {
            val items = async { dbSource.productDao().getProductWishlist() }.await()
            items.map { it.toProduct() }
        }
    }

}