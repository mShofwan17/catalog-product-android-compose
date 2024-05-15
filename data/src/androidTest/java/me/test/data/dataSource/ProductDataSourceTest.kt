package me.test.data.dataSource

import androidx.test.core.app.ApplicationProvider
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import me.test.data.DataTesting
import me.test.roomdb.CatalogProductDatabase
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test


@ExperimentalCoroutinesApi
class ProductDataSourceTest {
    private lateinit var dataTesting: DataTesting
    private lateinit var catalogProductDatabase: CatalogProductDatabase
    private lateinit var source: ProductDataSource

    @Before
    fun setUp() {
        dataTesting = DataTesting()
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
                dataTesting.allData,
                source.getAllProduct()
            )
        }

    @Test
    fun searchProductTest() =
        runTest {
            source.importProduct()
            assertEquals(
                dataTesting.searchData,
                source.searchProduct("air")
            )
        }

    @Test
    fun getProductDetailTest() =
        runTest {
            source.importProduct()
            //Log.i("TAG_detail", "getProductDetailTest: ${source.getDetailProduct(6)}")
            assertEquals(
                dataTesting.productDetail,
                source.getDetailProduct(5)
            )
        }

    /*    @Test
        fun getProductWishlistTest() =
            runTest {
                source.importProduct()
                //Log.i("TAG_detail", "getProductDetailTest: ${source.getDetailProduct(6)}")
                assertEquals(
                    dataTesting.productDetail,
                    source.getDetailProduct(5)
                )
            }*/
}