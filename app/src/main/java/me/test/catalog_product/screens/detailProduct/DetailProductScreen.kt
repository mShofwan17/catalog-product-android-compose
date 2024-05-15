package me.test.catalog_product.screens.detailProduct

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter
import me.test.catalog_product.R
import me.test.catalog_product.components.MyButton
import me.test.catalog_product.ui.UiState
import me.test.domain.uiModels.UiDetailProduct
import me.test.domain.utils.toIdrCurrency

@Composable
fun DetailProductScreen(
    navHostController: NavHostController,
    viewModel: DetailProductViewModel = hiltViewModel()
) {
    val product = viewModel.productDetail.collectAsState()
    val addToWishlist = viewModel.addToWishlist.collectAsState()


    product.value.ShowUIComposable(
        onSuccess = {
            DetailProductContent(
                navHostController = navHostController,
                item = it,
                addToWishlistState = addToWishlist.value,
                onActionButton = { isFavourite ->
                    viewModel.addToWishlist(it.id, isFavourite)
                }
            )
        },
        onError = { Toast.makeText(LocalContext.current, it, Toast.LENGTH_SHORT).show() }
    )
}

@Composable
fun DetailProductContent(
    navHostController: NavHostController,
    item: UiDetailProduct,
    addToWishlistState: UiState<Boolean>,
    onActionButton: (Boolean) -> Unit
) {
    val painterImage = rememberAsyncImagePainter(
        model = item.imageUrl,
        error = painterResource(id = R.drawable.image_error)
    )

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .verticalScroll(rememberScrollState())
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp)
            ) {
                Image(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight(),
                    painter = painterResource(id = R.drawable.half_elips),
                    contentDescription = stringResource(R.string.half_black),
                    contentScale = ContentScale.Crop
                )
                Icon(
                    modifier = Modifier
                        .size(50.dp)
                        .padding(top = 16.dp)
                        .clickable { navHostController.popBackStack() },
                    imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft,
                    contentDescription = stringResource(R.string.ic_back),
                    tint = Color.White
                )

                Image(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 30.dp, start = 16.dp, end = 16.dp)
                        .wrapContentHeight(),
                    painter = painterImage,
                    contentDescription = stringResource(id = R.string.image_url),
                    contentScale = ContentScale.Crop
                )
            }

            HorizontalDivider(
                modifier = Modifier
                    .padding(top = 24.dp, start = 16.dp, end = 16.dp),
                thickness = 1.dp,
                color = Color.LightGray
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp, start = 16.dp, end = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                item.brand?.let {
                    Text(
                        text = it,
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.SemiBold,
                        color = Color.Black
                    )
                }


                item.price?.let {
                    Text(
                        text = it.toDouble().toIdrCurrency(),
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.ExtraBold,
                        color = Color.Black
                    )
                }

            }

            item.name?.let {
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 4.dp, start = 16.dp, end = 16.dp),
                    text = it,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.Black
                )
            }

            HorizontalDivider(
                modifier = Modifier
                    .padding(top = 16.dp, start = 16.dp, end = 16.dp),
                thickness = 1.dp,
                color = Color.LightGray
            )

            item.description?.let {
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 16.dp, start = 16.dp, end = 16.dp),
                    text = it,
                    style = MaterialTheme.typography.titleSmall,
                    fontWeight = FontWeight.Normal,
                    color = Color.Black,
                    textAlign = TextAlign.Justify
                )
            }

            HorizontalDivider(
                modifier = Modifier
                    .padding(top = 16.dp, start = 16.dp, end = 16.dp),
                thickness = 1.dp,
                color = Color.LightGray
            )
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(all = 16.dp)
                .weight(1f),
        ) {
            addToWishlistState.ShowUIComposable(
                onLoading = {
                    CircularProgressIndicator(
                        modifier = Modifier
                            .wrapContentWidth()
                            .wrapContentHeight()
                            .align(Alignment.BottomCenter),
                        color = Color.Black
                    )
                },
                onSuccess = {
                    val modifier = Modifier.align(Alignment.BottomCenter)
                    var title = stringResource(R.string.tambahkan_ke_favorit)
                    var backgroundColor = Color.Black
                    var icon = Icons.Default.Favorite

                    if (it) {
                        title = stringResource(R.string.hapus_dari_favorit)
                        backgroundColor = Color.Red
                        icon = Icons.Default.Delete
                    }

                    MyButton(
                        modifier = modifier,
                        title = title,
                        backgroundColor = backgroundColor,
                        icon = icon,
                        onClick = {
                            onActionButton.invoke(!it)
                        }
                    )
                },
                onError = {}
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun DetailProductPrev() {
    val productDetail = UiDetailProduct(
        id = 5,
        name = "Run Star Hike Three Color Unisex",
        brand = "Converse",
        price = 2500000,
        description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum diam tellus, porta a condimentum vitae, posuere quis tortor. Praesent sed cursus dolor. Integer dapibus at nulla eget fermentum. Aenean consequat, ligula quis egestas ornare, neque erat scelerisque tellus, in vulputate neque risus eu erat. Pellentesque dignissim dictum sapien eget pretium. Fusce ullamcorper elit et elit finibus ullamcorper. Quisque ullamcorper interdum turpis, vitae volutpat felis porttitor nec. Nullam accumsan turpis ut feugiat egestas. Etiam tempus ullamcorper elit, sit amet gravida purus. Curabitur euismod id lacus sed malesuada. Nulla ipsum ex, tempor non enim vitae, ullamcorper lobortis arcu.",
        imageUrl = "",
        isFavourite = false,
    )
    /* DetailProductContent(
         navHostController = rememberNavController(),
         item = productDetail,
         onActionButton = {

         }
     )*/
}