package me.test.catalog_product.screens.search

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import me.test.catalog_product.ui.UiState
import me.test.domain.uiModels.UiListProduct
import me.test.domain.usecases.product.SearchProductsUseCase
import me.test.domain.utils.ResponseState
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val searchProductsUseCase: SearchProductsUseCase
) : ViewModel() {
    private val _products = MutableStateFlow(UiState<List<UiListProduct>>())
    val productsSearch get() = _products.asStateFlow()

    private val _searchQuery = mutableStateOf("")
    val searchQuery = _searchQuery

    fun updateSearchQuery(query: String) {
        _searchQuery.value = query
    }

    fun getProductsSearch(name: String) {
        viewModelScope.launch {
            searchProductsUseCase(name).collectLatest { result ->
                _products.update {
                    when (result) {
                        is ResponseState.Loading -> it.loading()
                        is ResponseState.Success -> it.success(result.data)
                        is ResponseState.Error -> it.error(result.message)
                    }
                }
            }
        }
    }
}