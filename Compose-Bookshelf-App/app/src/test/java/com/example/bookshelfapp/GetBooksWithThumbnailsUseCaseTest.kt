package com.example.bookshelfapp

import com.example.bookshelfapp.data.BooksRepository
import com.example.bookshelfapp.domain.GetBookIdUseCase
import com.example.bookshelfapp.domain.GetBooksWithThumbnailsUseCase
import com.example.bookshelfapp.domain.SetHttpsUseCase
import com.example.bookshelfapp.fake.BooksFakeDataSource
import com.example.bookshelfapp.fake.ThumbnailFakeDataSource
import com.example.bookshelfapp.ui.BooksUiModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class GetBooksWithThumbnailsUseCaseTest {

    private lateinit var getBooksWithThumbnailsUseCase: GetBooksWithThumbnailsUseCase

    @Before
    fun createGetBooksWithThumbnailsUseCase() {
        val getBookIdUseCase = GetBookIdUseCase(
            defaultDispatcher = Dispatchers.Default
        )

        val booksRepository = BooksRepository(
            booksDataSource = BooksFakeDataSource(),
            thumbnailDataSource = ThumbnailFakeDataSource()
        )

        val setHttpsUseCase = SetHttpsUseCase(
            defaultDispatcher = Dispatchers.Default
        )

        getBooksWithThumbnailsUseCase = GetBooksWithThumbnailsUseCase(
            booksRepository = booksRepository,
            defaultDispatcher = Dispatchers.Default,
            getBookIdUseCase = getBookIdUseCase,
            setHttpsUseCase = setHttpsUseCase,
        )
    }

    @Test
    fun getBooksWithThumbnailUseCaseTest_GetBooksWithThumbnail_GetBooksWithThumbnailSuccess() {
        runTest {
            val books = getBooksWithThumbnailsUseCase("fake")
            Assert.assertEquals(
                books[0],
                BooksUiModel(id = "id1", title = "title1", url = "thumbnail")
            )
        }
    }
}