package com.example.bookshelfapp

import com.example.bookshelfapp.domain.GetBookIdUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class GetBookIdUseCaseTest {
    private lateinit var getBookIdUseCase: GetBookIdUseCase

    @Before
    fun createGetBookIdUseCase() {
        getBookIdUseCase = GetBookIdUseCase(Dispatchers.Default)
    }

    @Test
    fun getBookIdUseCaseText_getBookId_getBookIdSuccess() {
        runTest {
            val bookId = getBookIdUseCase("https://fake.com/fake")
            assertEquals("fake", bookId)
        }
    }
}