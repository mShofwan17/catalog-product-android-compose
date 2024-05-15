package me.test.catalog_product.components

import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onChildren
import androidx.compose.ui.test.onFirst
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.performClick
import me.test.domain.uiModels.UiListProduct
import org.junit.Rule
import org.junit.Test

class ListContentTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    private val items = listOf(
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

    @Test
    fun listContent_assertIsDisplayed() {
        composeTestRule.setContent {
            ListGridContent(
                items = items,
                onItemClick = { }
            )
        }

        composeTestRule.onNodeWithContentDescription("ListContent").assertIsDisplayed()
    }

    @Test
    fun listContent_selectedItem_exitListContent() {
        val searchWidgetShown = mutableStateOf(true)
        composeTestRule.setContent {
            if (searchWidgetShown.value) {
                ListGridContent(
                    items = items,
                    onItemClick = { searchWidgetShown.value = false }
                )
            }

        }

        composeTestRule.onNodeWithContentDescription("ListContent")
            .onChildren()
            .onFirst()
            .performClick()
        composeTestRule.onNodeWithContentDescription("ListContent").assertDoesNotExist()
    }
}