package com.androiditems.usecases

import com.androiditems.models.Item
import com.androiditems.models.Result
import com.androiditems.repositories.IItemsRepository
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
class CreateItemUseCaseTest {

    private lateinit var useCase: ICreateItemUseCase
    private val repository = mockk<IItemsRepository>()
    private val testItem = Item("id4", "name 4")

    @Before
    fun setUp() {
        coEvery { repository.createItem(testItem) } returns Result.Success(testItem)
        coEvery { repository.getItemById("id1") } returns Result.Success(Item("id1", "name 1"))
        useCase = CreateItemUseCase(repository)
    }

    @Test
    fun `invoke calls repository createItem`(): Unit = runTest {
        useCase(testItem)
        delay(1000L) // wait for createItem to be called asynchronously
        coVerify { repository.createItem(testItem) }
    }

    @Test
    fun `invoke with blank id returns error`() = runTest {
        val item = Item("", "Valid Item")
        val result = useCase(item)
        assert(result is Result.Error<*>)
    }

}