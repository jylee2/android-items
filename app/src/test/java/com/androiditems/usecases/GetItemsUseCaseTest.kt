package com.androiditems.usecases

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
class GetItemsUseCaseTest {

    private val repository = mockk<IItemsRepository>()
    private lateinit var useCase: IGetItemsUseCase
    private val testResult = Result.Success(
        listOf(
            Item("id1", "name 1"),
            Item("id2", "name 2"),
            Item("id3", "name 3")
        )
    )

    @Before
    fun setUp() {
        coEvery { repository.loadItems() } returns testResult
        useCase = GetItemsUseCase(repository)
    }

    @Test
    fun `invoke adds item to repository`(): Unit = runTest {
        useCase()
        coVerify { repository.loadItems() }
    }

}