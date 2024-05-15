package me.test.catalog_product.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberAsyncImagePainter
import me.test.catalog_product.R
import me.test.catalog_product.navigation.Screens
import me.test.domain.uiModels.UiListProduct
import me.test.domain.utils.toIdrCurrency

@Composable
fun ListGridContent(
    modifier: Modifier = Modifier,
    items: List<UiListProduct>,
    onItemClick: (UiListProduct) -> Unit
) {
    LazyVerticalGrid(
        modifier = modifier,
        columns = GridCells.Fixed(2)
    ) {
        items(items.size) {
            ItemProduct(
                modifier = Modifier.padding(8.dp),
                item = items[it],
                onClick = { item -> onItemClick.invoke(item) }
            )
        }
    }
}

@Composable
fun ItemProduct(
    modifier: Modifier = Modifier,
    item: UiListProduct,
    onClick: (UiListProduct) -> Unit
) {
    val painterImage = rememberAsyncImagePainter(
        model = item.imageUrl,
        error = painterResource(id = R.drawable.image_error)
    )

    Card(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .clip(shape = RoundedCornerShape(12.dp))
            .clickable { onClick.invoke(item) },
        colors = CardDefaults.cardColors(
            containerColor = Color.White,
            contentColor = Color.White
        ),
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(all = 12.dp)
        ) {
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(all = 8.dp)
                    .height(120.dp),
                painter = painterImage,
                contentDescription = stringResource(R.string.image_url),
                contentScale = ContentScale.Inside
            )

            Text(
                modifier = Modifier.padding(top = 8.dp),
                text = item.brand!!,
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.SemiBold,
                color = Color.Black
            )

            Text(
                modifier = Modifier.padding(top = 6.dp),
                text = item.name!!,
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.Normal,
                color = Color.Gray,
                overflow = TextOverflow.Ellipsis,
                maxLines = 2
            )

            Text(
                modifier = Modifier.padding(top = 2.dp),
                text = item.price?.toDouble().toIdrCurrency(),
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.SemiBold,
                color = Color.Black
            )
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0x9EFFFFFF)
@Composable
private fun ItemProductPrev() {
    val item = listOf(
        UiListProduct(
            id = 1,
            name = "Air Force 1 Jester XX Black Sonic Yellow",
            brand = "Nike",
            price = 1500000,
            imageUrl = "https://images.unsplash.com/photo-1628373383885-4be0bc0172fa?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=1301&q=80",
            isFavourite = false
        ),
        UiListProduct(
            id = 1,
            name = "Air Force 1 Jester XX Black Sonic Yellow",
            brand = "Nike",
            price = 1500000,
            imageUrl = "https://images.unsplash.com/photo-1628373383885-4be0bc0172fa?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=1301&q=80",
            isFavourite = false
        ),
        UiListProduct(
            id = 1,
            name = "Air Force 1 Jester XX Black Sonic Yellow",
            brand = "Nike",
            price = 1500000,
            imageUrl = "https://images.unsplash.com/photo-1628373383885-4be0bc0172fa?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=1301&q=80",
            isFavourite = false
        ),
        UiListProduct(
            id = 1,
            name = "Air Force 1 Jester XX Black Sonic Yellow",
            brand = "Nike",
            price = 1500000,
            imageUrl = "https://images.unsplash.com/photo-1628373383885-4be0bc0172fa?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=1301&q=80",
            isFavourite = false
        )
    )

    ListGridContent(items = item, onItemClick = {})
}