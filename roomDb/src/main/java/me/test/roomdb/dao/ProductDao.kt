package me.test.roomdb.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import me.test.roomdb.entity.ProductEntity

@Dao
interface ProductDao {
    @Query("SELECT * FROM tb_product")
    suspend fun getAll(): List<ProductEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun add(items: List<ProductEntity>): List<Long>

    @Update
    suspend fun update(item: ProductEntity): Int

    @Query("SELECT * FROM tb_product WHERE id=:id")
    suspend fun getDetailProduct(id: Long): ProductEntity

    @Query("SELECT * FROM tb_product WHERE name LIKE '%'|| :name || '%'")
    suspend fun searchProducts(name: String): List<ProductEntity>


    @Query("SELECT * FROM tb_product WHERE isFavourite=1")
    suspend fun getProductWishlist(): List<ProductEntity>

    @Delete
    suspend fun delete(items: ProductEntity): Int

    @Query("DELETE FROM tb_product")
    suspend fun deleteAll(): Int
}