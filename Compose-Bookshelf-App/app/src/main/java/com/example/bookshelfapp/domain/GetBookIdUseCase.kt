package com.example.bookshelfapp.domain

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetBookIdUseCase @Inject constructor(
    private val defaultDispatcher: CoroutineDispatcher
) {
    suspend operator fun invoke(url: String): String {
        return withContext(defaultDispatcher) {
            url.split('/').last()
        }
    }
}