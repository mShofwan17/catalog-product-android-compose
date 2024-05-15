package me.test.domain.utils

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlin.coroutines.CoroutineContext

open class BaseUseCase {
    suspend fun <T> doFlow(
        coroutineContext: CoroutineContext = Dispatchers.IO,
        block: suspend FlowCollector<ResponseState<T>>.() -> Unit
    ) : Flow<ResponseState<T>> {
        return flow {
            emit(ResponseState.Loading())
            try {
                block.invoke(this)
            } catch (e: Exception) {
                emit(ResponseState.Error(e.message))
            }
        }.flowOn(coroutineContext)
    }

}