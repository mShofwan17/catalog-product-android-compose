package me.test.domain.usecases.product

import kotlinx.coroutines.flow.Flow
import me.test.data.repository.product.ProductRepository
import me.test.domain.uiModels.UiDetailProduct
import me.test.domain.uiModels.UiListProduct
import me.test.domain.uiModels.toDetailProduct
import me.test.domain.uiModels.toListProduct
import me.test.domain.utils.BaseUseCase
import me.test.domain.utils.ResponseState
import javax.inject.Inject

class GetDetailProductUseCase @Inject constructor(
    private val repository: ProductRepository
): BaseUseCase() {
    suspend operator fun invoke(id: Long) : Flow<ResponseState<UiDetailProduct>>{
        return doFlow {
            val items = repository.getDetailProduct(id = id).toDetailProduct()
            emit(ResponseState.Success(items))
        }
    }
}