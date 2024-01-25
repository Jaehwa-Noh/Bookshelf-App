package com.example.bookshelfapp.data

import com.example.bookshelfapp.di.DispatcherIO
import com.example.bookshelfapp.model.GoogleBookApiModel
import com.example.bookshelfapp.network.GoogleBookApiService
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

interface BooksDataSource {
    suspend fun getBooks(searchTerms: String): GoogleBookApiModel
}

@Singleton
class BooksNetworkDataSource @Inject constructor(
    private val googleBookApiService: GoogleBookApiService,
    @DispatcherIO private val ioDispatcher: CoroutineDispatcher
) : BooksDataSource {
    override suspend fun getBooks(searchTerms: String): GoogleBookApiModel {
        return withContext(ioDispatcher) {
            googleBookApiService.getBooks(searchTerms = searchTerms)
        }
    }
}