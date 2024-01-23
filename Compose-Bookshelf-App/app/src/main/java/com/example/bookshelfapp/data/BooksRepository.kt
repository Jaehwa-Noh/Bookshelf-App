package com.example.bookshelfapp.data

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class BooksRepository @Inject constructor(
    private val booksDataSource: BooksDataSource,
    private val thumbnailDataSource: BookThumbnailDataSource
) {
    suspend fun getBooks(searchTerms: String) {
        booksDataSource.getBooks(searchTerms = searchTerms)
    }

    suspend fun getThumbnails(bookId: String) {
        thumbnailDataSource.getThumbnails(bookId = bookId)
    }
}