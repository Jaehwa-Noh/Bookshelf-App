package com.example.bookshelfapp.data

import com.example.bookshelfapp.di.DispatcherIO
import com.example.bookshelfapp.model.GoogleBookRetrieveApiModel
import com.example.bookshelfapp.network.GoogleBookApiService
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

interface BookThumbnailDataSource {
    suspend fun getThumbnails(bookId: String): GoogleBookRetrieveApiModel
}

@Singleton
class BookThumbnailNetworkDataSource @Inject constructor(
    private val googleBookApiService: GoogleBookApiService,
    @DispatcherIO private val ioDispatcher: CoroutineDispatcher
) : BookThumbnailDataSource {
    override suspend fun getThumbnails(bookId: String): GoogleBookRetrieveApiModel {
        return withContext(ioDispatcher) {
            googleBookApiService.getThumbnails(bookId = bookId)
        }
    }
}