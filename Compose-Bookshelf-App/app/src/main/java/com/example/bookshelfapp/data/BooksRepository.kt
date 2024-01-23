package com.example.bookshelfapp.data

import com.example.bookshelfapp.model.GoogleBookApiModel
import com.example.bookshelfapp.model.GoogleBookRetrieveApiModel
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class BooksRepository @Inject constructor(
    private val booksDataSource: BooksDataSource,
    private val thumbnailDataSource: BookThumbnailDataSource
) {
    suspend fun getBooks(searchTerms: String): GoogleBookApiModel {
        return booksDataSource.getBooks(searchTerms = searchTerms)
    }

    suspend fun getThumbnails(bookId: String): GoogleBookRetrieveApiModel {
        return thumbnailDataSource.getThumbnails(bookId = bookId)
    }
}