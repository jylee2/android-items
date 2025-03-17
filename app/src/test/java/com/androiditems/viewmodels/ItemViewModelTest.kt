package com.androiditems.viewmodels

import com.androiditems.models.Item
import com.androiditems.models.Result
import com.androiditems.usecases.ICreateItemUseCase
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.delay
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class ItemViewModelTest {

    private lateinit var viewModel: IItemViewModel
    private val testItem = Item("id1", "name 1")
    private val createItemUseCase = mockk<ICreateItemUseCase>()

    @Before
    fun setUp() {
        coEvery { createItemUseCase(testItem) } returns Result.Success(testItem)
        viewModel = ItemViewModel(createItemUseCase)
    }

    @Test
    fun `viewModel calls repository createItem`(): Unit = runTest {
        viewModel.createItem(testItem, {})
        delay(1000L) // wait for createItemUseCase to be called asynchronously
        coVerify { createItemUseCase(testItem) }
    }

}