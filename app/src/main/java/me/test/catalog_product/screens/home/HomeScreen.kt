package me.test.catalog_product.screens.home

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import me.test.catalog_product.components.CatalogSearchBar
import me.test.catalog_product.components.ListGridContent
import me.test.catalog_product.navigation.Screens

@Composable
fun HomeScreen(
    navHostController: NavHostController,
    viewModel: HomeViewModel = hiltViewModel()
) {
    val listProduct = viewModel.products.collectAsStateWithLifecycle()
    val countProduct = viewModel.countProduct.collectAsStateWithLifecycle()
    var showWishlist by remember {
        mutableStateOf(false)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        CatalogSearchBar(
            modifier = Modifier.padding(start = 16.dp, top = 16.dp, end = 16.dp, bottom = 8.dp),
            onClick = { }
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp, start = 16.dp, end = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(
                    text = "Sneakers",
                    style = MaterialTheme.typography.displaySmall,
                    fontWeight = FontWeight.SemiBold
                )

                Text(
                    modifier = Modifier.padding(top = 2.dp),
                    text = "${countProduct.value} produk tersedia"
                )
            }

            Icon(
                modifier = Modifier
                    .size(30.dp)
                    .clickable {
                        showWishlist = !showWishlist

                        if (showWishlist) viewModel.getProductsWishlist()
                        else viewModel.getProducts()
                    },
                imageVector = if (showWishlist) Icons.Default.Favorite
                else Icons.Default.FavoriteBorder,
                contentDescription = "ic_fav"
            )
        }

        listProduct.value.ShowUIComposable(
            onSuccess = {
                if (it.isNotEmpty()) {
                    ListGridContent(
                        modifier = Modifier.padding(start = 8.dp, end = 8.dp),
                        items = it,
                        onItemClick = { item ->
                            viewModel.getProducts()
                            navHostController.navigate(Screens.DetailProduct.passId(item.id))
                        }
                    )
                }

                if (showWishlist && it.isEmpty()) {
                    Text(
                        modifier = Modifier
                            .fillMaxSize()
                            .wrapContentHeight()
                            .padding(16.dp),
                        text = "Belum ada Wishlist ditambahkan",
                        style = MaterialTheme.typography.headlineLarge,
                        fontWeight = FontWeight.SemiBold,
                        textAlign = TextAlign.Center,
                        minLines = 2
                    )
                }

            },
            onError = {
                Toast.makeText(LocalContext.current, it, Toast.LENGTH_SHORT).show()
            }
        )

    }
}

@Preview(showBackground = true, showSystemUi = false)
@Composable
private fun HomeScreenPrev() {
    HomeScreen(navHostController = rememberNavController())
}