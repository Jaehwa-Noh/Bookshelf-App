package com.example.bookshelfapp.domain

import com.example.bookshelfapp.di.DispatcherDefault
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class SetHttpsUseCase @Inject constructor(
    @DispatcherDefault private val defaultDispatcher: CoroutineDispatcher
) {
    suspend operator fun invoke(url: String): String {
        return withContext(defaultDispatcher) {
            url.replace("http", "https")
        }
    }
}