package me.test.catalog_product.screens.detailProduct

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import me.test.catalog_product.ui.UiState
import me.test.domain.uiModels.UiDetailProduct
import me.test.domain.usecases.product.GetDetailProductUseCase
import me.test.domain.usecases.wishlist.AddToWishlistUseCase
import me.test.domain.utils.ResponseState
import me.test.domain.utils.UiConstant.ArgumentConst.ID_ARG
import javax.inject.Inject

@HiltViewModel
class DetailProductViewModel @Inject constructor(
    private val getDetailProductUseCase: GetDetailProductUseCase,
    private val addToWishlistUseCase: AddToWishlistUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {
    private val _productDetail = MutableStateFlow(UiState<UiDetailProduct>())
    val productDetail get() = _productDetail.asStateFlow()

    private val _addToWishlist = MutableStateFlow(UiState<Boolean>())
    val addToWishlist get() = _addToWishlist.asStateFlow()

    init {
        val id: Long? = savedStateHandle[ID_ARG]
        id?.let {
            getProductDetail(id)
        }
    }

    private fun getProductDetail(id: Long) {
        viewModelScope.launch {
            getDetailProductUseCase(id).collectLatest { result ->
                _productDetail.update {
                    when (result) {
                        is ResponseState.Loading -> it.loading()
                        is ResponseState.Success -> {
                            _addToWishlist.update { addToWishlist ->
                                addToWishlist.success(result.data?.isFavourite)
                            }
                            it.success(result.data)
                        }

                        is ResponseState.Error -> it.error(result.message)
                    }
                }
            }
        }
    }

    fun addToWishlist(id: Long, isFavourite: Boolean) {
        viewModelScope.launch {
            addToWishlistUseCase(id, isFavourite).collectLatest { result ->
                _addToWishlist.update {
                    when (result) {
                        is ResponseState.Loading -> it.loading()
                        is ResponseState.Success -> it.success(result.data?.isFavourite)
                        is ResponseState.Error -> it.error(result.message)
                    }
                }
            }
        }
    }
}