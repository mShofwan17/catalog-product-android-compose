package me.test.domain.usecases.product

import kotlinx.coroutines.flow.Flow
import me.test.data.repository.product.ProductRepository
import me.test.domain.uiModels.UiListProduct
import me.test.domain.uiModels.toListProduct
import me.test.domain.utils.BaseUseCase
import me.test.domain.utils.ResponseState
import javax.inject.Inject

class GetProductsUseCase @Inject constructor(
    private val repository: ProductRepository
) : BaseUseCase() {
    suspend operator fun invoke(): Flow<ResponseState<List<UiListProduct>>> {
        return doFlow {
            val items = repository.getAllProducts().map { it.toListProduct() }
            emit(ResponseState.Success(items))
        }
    }
}