package me.test.catalog_product.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import me.test.catalog_product.R

@Composable
fun MyButton(
    modifier: Modifier = Modifier,
    icon: ImageVector? = null,
    title: String,
    backgroundColor: Color,
    contentColor: Color = Color.White,
    contentLoading: Boolean = false,
    onClick: () -> Unit
) {
    Box(
        modifier = modifier
            .clickable { onClick() }
            .fillMaxWidth()
            .height(56.dp)
            .clip(shape = RoundedCornerShape(10.dp))
            .background(backgroundColor),
        contentAlignment = Alignment.Center
    ) {
        if (contentLoading) {
            CircularProgressIndicator(color = Color.White)
        } else {
            Row {
                icon?.let {
                    Icon(
                        modifier = Modifier.padding(
                            top = 2.dp,
                            end = 10.dp
                        ),
                        imageVector = icon,
                        contentDescription = stringResource(R.string.icon_button),
                        tint = contentColor
                    )
                }
                Text(
                    modifier = Modifier,
                    text = title,
                    color = contentColor,
                    fontSize = MaterialTheme.typography.titleLarge.fontSize
                )
            }
        }
    }
}

@Preview
@Composable
fun PreviewButton() {

    Column {
        MyButton(
            title = "Tambahkan ke Favorit",
            backgroundColor = Color.Black,
            icon = Icons.Default.Favorite,
            onClick = {

            }
        )

        Spacer(modifier = Modifier.padding(top = 16.dp))

        MyButton(
            title = "Hapus dari Favorit",
            backgroundColor = Color.Red,
            icon = Icons.Default.Delete,
            onClick = {

            }
        )
    }

}
