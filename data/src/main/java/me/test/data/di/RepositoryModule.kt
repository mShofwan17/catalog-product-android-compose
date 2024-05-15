package me.test.data.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import me.test.data.dataSource.ProductDataSource
import me.test.data.repository.product.ProductRepository
import me.test.data.repository.product.ProductRepositoryImpl
import me.test.data.repository.wishlist.WishlistRepository
import me.test.data.repository.wishlist.WishlistRepositoryImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    @Singleton
    fun proideProductRepository(
        dataSource: ProductDataSource
    ): ProductRepository {
        return ProductRepositoryImpl(dataSource)
    }

    @Provides
    @Singleton
    fun proideWishlistRepository(
        dataSource: ProductDataSource
    ): WishlistRepository {
        return WishlistRepositoryImpl(dataSource)
    }
}