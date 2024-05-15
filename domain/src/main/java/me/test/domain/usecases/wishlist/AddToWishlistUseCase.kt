package me.test.domain.usecases.wishlist

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import me.test.data.repository.wishlist.WishlistRepository
import me.test.domain.uiModels.UiDetailProduct
import me.test.domain.uiModels.toDetailProduct
import me.test.domain.utils.BaseUseCase
import me.test.domain.utils.ResponseState
import javax.inject.Inject

class AddToWishlistUseCase @Inject constructor(
    private val repository: WishlistRepository
) : BaseUseCase() {
    suspend operator fun invoke(id: Long, isFavourite: Boolean): Flow<ResponseState<UiDetailProduct>> {
        return doFlow {
            val result = repository.addToWishlist(id,isFavourite)
            delay(1000L)
            emit(ResponseState.Success(result.toDetailProduct()))
        }
    }
}