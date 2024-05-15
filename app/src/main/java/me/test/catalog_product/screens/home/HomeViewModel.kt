package me.test.catalog_product.screens.home

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
import me.test.domain.usecases.product.GetProductsUseCase
import me.test.domain.usecases.wishlist.GetWishlistsUseCase
import me.test.domain.utils.ResponseState
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getProductsUseCase: GetProductsUseCase,
    private val getWishlistsUseCase: GetWishlistsUseCase
) : ViewModel() {
    private val _products = MutableStateFlow(UiState<List<UiListProduct>>())
    val products get() = _products.asStateFlow()

    private val _countProducts = MutableStateFlow(0)
    val countProduct get() = _countProducts.asStateFlow()

    init {
        getProducts()
    }

    fun getProducts() {
        viewModelScope.launch {
            getProductsUseCase().collectLatest { result ->
                _products.update {
                    when (result) {
                        is ResponseState.Loading -> it.loading()
                        is ResponseState.Success -> {
                            result.data?.size?.let { size ->
                                _countProducts.value = size
                            }
                            it.success(result.data)
                        }

                        is ResponseState.Error -> it.error(result.message)
                    }
                }
            }
        }
    }

    fun getProductsWishlist() {
        viewModelScope.launch {
            getWishlistsUseCase().collectLatest { result ->
                _products.update {
                    when (result) {
                        is ResponseState.Loading -> it.loading()
                        is ResponseState.Success -> {
                            result.data?.size?.let { size ->
                                _countProducts.value = size
                            }
                            it.success(result.data)
                        }

                        is ResponseState.Error -> it.error(result.message)
                    }
                }
            }
        }
    }
}