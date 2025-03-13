package com.androiditems.ui

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import com.androiditems.models.Item
import com.androiditems.viewmodels.IItemViewModel
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import org.junit.Rule
import org.junit.Test

class ItemDetailsKtTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun rendertemDetails() {
        val itemViewModel = mockk<IItemViewModel>()
        every { itemViewModel.selectedItem } returns MutableStateFlow(
            Item("id1", "Item 1")
        ).asStateFlow()

        composeTestRule.setContent {
            ItemDetails(itemViewModel) {}
        }

        composeTestRule.onNodeWithText("ID: id1").assertIsDisplayed()
        composeTestRule.onNodeWithText("Name: Item 1").assertIsDisplayed()
    }

}