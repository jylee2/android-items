package com.androiditems.ui

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import com.androiditems.models.Item
import com.androiditems.models.Result
import org.junit.Rule
import org.junit.Test

class ItemsListKtTest {

    @get:Rule
    val composeTestRule = createComposeRule()
    private val testItems = Result.Success(
        listOf(
            Item("id1", "name11"),
            Item("id2", "name22"),
            Item("id3", "name33"),
            Item("id4", "name44"),
            Item("id5", "name55"),
            Item("id6", "name66")
        )
    )

    @Test
    fun renderListOfItems() {
        composeTestRule.setContent {
            ItemsList(testItems) {}
        }

        composeTestRule.onNodeWithText("Name: name11").assertIsDisplayed()
        composeTestRule.onNodeWithText("Name: name22").assertIsDisplayed()
    }

}