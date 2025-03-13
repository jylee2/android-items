package com.androiditems.viewmodels

import com.androiditems.models.Item
import com.androiditems.models.Result
import com.androiditems.repositories.IItemsRepository
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class ItemViewModelTest {

    private val repository = mockk<IItemsRepository>()
    private lateinit var viewModel: IItemViewModel
    private val testItem = Item("id1", "name 1")

    @Before
    fun setUp() {
        coEvery { repository.createItem(testItem) } returns Result.Success(testItem)
        viewModel = ItemViewModel(repository)
    }

    @Test
    fun `viewModel calls repository createItem`(): Unit = runTest {
        viewModel.createItem(testItem, {})
        coVerify { repository.createItem(testItem) }
    }

}