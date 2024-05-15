package me.test.catalog_product.screens.search

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import me.test.catalog_product.components.CatalogSearchBar
import me.test.catalog_product.components.ListGridContent
import me.test.catalog_product.navigation.Screens
import me.test.catalog_product.ui.theme.BgColor

@Composable
fun SearchScreen(
    navHostController: NavHostController,
    viewModel: SearchViewModel = hiltViewModel()
) {
    val searchQuery by viewModel.searchQuery
    val listProduct = viewModel.productsSearch.collectAsStateWithLifecycle()

    Scaffold(
        containerColor = BgColor,
        topBar = {
            CatalogSearchBar(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(16.dp),
                text = searchQuery,
                onTextChange = {
                    viewModel.updateSearchQuery(query = it)
                },
                onSearchClicked = {
                    viewModel.getProductsSearch(name = it)
                },
                onCloseClicked = {
                    navHostController.popBackStack()
                }
            )
        },
        content = { padding ->
            listProduct.value.ShowUIComposable(
                onLoading = {
                    CircularProgressIndicator(
                        modifier = Modifier.fillMaxSize(),
                        color = Color.Black
                    )
                },
                onSuccess = {
                    ListGridContent(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(paddingValues = padding)
                            .background(BgColor),
                        items = it,
                        onItemClick = { item ->
                            navHostController.navigate(Screens.DetailProduct.passId(item.id))
                        }
                    )
                },
                onError = { Toast.makeText(LocalContext.current, it, Toast.LENGTH_SHORT).show() }
            )

        }
    )
}