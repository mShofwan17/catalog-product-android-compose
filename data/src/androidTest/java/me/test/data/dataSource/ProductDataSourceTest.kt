package me.test.data.dataSource

import androidx.test.core.app.ApplicationProvider
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import me.test.data.utils.ProductDataTest
import me.test.roomdb.CatalogProductDatabase
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test


@ExperimentalCoroutinesApi
class ProductDataSourceTest {
    private lateinit var productDataTest: ProductDataTest
    private lateinit var catalogProductDatabase: CatalogProductDatabase
    private lateinit var source: ProductDataSource

    @Before
    fun setUp() {
        productDataTest = ProductDataTest()
        catalogProductDatabase = CatalogProductDatabase.create(
            context = ApplicationProvider.getApplicationContext(),
            useInMemory = true
        )
        source = ProductDataSource(catalogProductDatabase)

    }

    @After
    fun cleanUp() {
        catalogProductDatabase.clearAllTables()
    }

    @Test
    fun getAllProductData() =
        runTest {
            assertEquals(
                productDataTest.allData,
                source.getAllProduct()
            )
        }

    @Test
    fun searchProductTest() =
        runTest {
            source.importProduct()
            assertEquals(
                productDataTest.searchData,
                source.searchProduct("air")
            )
        }

    @Test
    fun getProductDetailTest() =
        runTest {
            source.importProduct()
            assertEquals(
                productDataTest.productDetail,
                source.getDetailProduct(5)
            )
        }

    @Test
    fun getProductWishlistTest() =
        runTest {
            source.importProduct()
            assertEquals(
                productDataTest.productWishlist,
                source.getProductWishlist()
            )
        }
}