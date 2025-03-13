package com.androiditems.ui

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import com.androiditems.models.Item
import org.junit.Rule
import org.junit.Test

class ItemsListKtTest {

    @get:Rule
    val composeTestRule = createComposeRule()
    private val testItems = listOf(
        Item("id1", "name1"),
        Item("id2", "name2"),
        Item("id3", "name3"),
        Item("id4", "name4"),
        Item("id5", "name5"),
        Item("id6", "name6")
    )

    @Test
    fun renderListOfItems() {
        composeTestRule.setContent {
            ItemsList(testItems)
        }

        composeTestRule.onNodeWithText("name1").assertIsDisplayed()
        composeTestRule.onNodeWithText("name2").assertIsDisplayed()
    }

}