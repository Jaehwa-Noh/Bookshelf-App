package com.example.bookshelfapp

import com.example.bookshelfapp.domain.SetHttpsUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class SetHttpsUseCaseTest {
    private lateinit var setHttpsUseCase: SetHttpsUseCase

    @Before
    fun createSetHttpsUseCase() {
        setHttpsUseCase = SetHttpsUseCase(Dispatchers.Default)
    }

    @Test
    fun setHttpsUseCase_HttpToHttps_HttpsSuccess() = runTest {
        val result = setHttpsUseCase("http://")
        assertEquals("https://", result)
    }
}