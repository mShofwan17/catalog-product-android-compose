package me.test.catalog_product.components

import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.test.assertTextContains
import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import org.junit.Rule
import org.junit.Test

class SearchBarTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun catalogSearchBar_addInputText_assertInputText() {
        val text = mutableStateOf("")
        composeTestRule.setContent {
            CatalogSearchBar(text = text.value,
                onTextChange = {
                    text.value = it
                },
                onSearchClicked = {},
                onCloseClicked = {}
            )
        }

        composeTestRule.onNodeWithContentDescription("SearchTextField")
            .performTextInput("Air")
        composeTestRule.onNodeWithContentDescription("SearchTextField")
            .assertTextEquals("Air")
    }

    @Test
    fun catalogSearchBar_onCloseClicked_assertClearText() {
        val text = mutableStateOf("")
        composeTestRule.setContent {
            CatalogSearchBar(text = text.value,
                onTextChange = {
                    text.value = it
                },
                onSearchClicked = {},
                onCloseClicked = {}
            )

        }

        composeTestRule.onNodeWithContentDescription("SearchTextField")
            .performTextInput("Air")
        composeTestRule.onNodeWithContentDescription("CloseButton")
            .performClick()
        composeTestRule.onNodeWithContentDescription("SearchTextField")
            .assertTextContains("")
    }
    @Test
    fun catalogSearchBar_onCloseClicked_assertCloseSearch() {
        val text = mutableStateOf("")
        val searchWidgetShown = mutableStateOf(true)
        composeTestRule.setContent {
            if (searchWidgetShown.value){
                CatalogSearchBar(text = text.value,
                    onTextChange = {
                        text.value = it
                    },
                    onSearchClicked = {},
                    onCloseClicked = {
                        searchWidgetShown.value = false
                    }
                )
            }

        }

        composeTestRule.onNodeWithContentDescription("CloseButton")
            .performClick()
        composeTestRule.onNodeWithContentDescription("CatalogSearchBar")
            .assertDoesNotExist()
    }
}