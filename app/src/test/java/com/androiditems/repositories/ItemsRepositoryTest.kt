package com.androiditems.repositories

import com.androiditems.models.Item
import com.androiditems.models.Result
import com.androiditems.services.IItemsService
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class ItemsRepositoryTest {

    private val service = mockk<IItemsService>()
    private lateinit var repository: IItemsRepository
    private val testItem = Item("id1", "name 1")

    @Before
    fun setUp() {
        coEvery { service.createItem(testItem) } returns Result.Success(testItem)
        repository = ItemsRepository(service)
    }

    @Test
    fun `repository calls service createItem`(): Unit = runTest {
        repository.createItem(testItem)
        coVerify { service.createItem(testItem) }
    }

}