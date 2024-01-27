package com.example.bookshelfapp

import com.example.bookshelfapp.data.BooksRepository
import com.example.bookshelfapp.domain.GetBookIdUseCase
import com.example.bookshelfapp.domain.GetBooksWithThumbnailsUseCase
import com.example.bookshelfapp.domain.SetHttpsUseCase
import com.example.bookshelfapp.fake.BooksFakeDataSource
import com.example.bookshelfapp.fake.ThumbnailFakeDataSource
import com.example.bookshelfapp.rules.TestDispatcherRule
import com.example.bookshelfapp.ui.BookShelfUiState
import com.example.bookshelfapp.ui.BooksUiModel
import com.example.bookshelfapp.ui.BookshelfViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Rule
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */

class BookshelfViewModelTest {
    private lateinit var bookshelfViewModel: BookshelfViewModel

    @get:Rule
    val testDispatcher = TestDispatcherRule()

    @Before
    fun createBookshelfViewModel() {
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

        val getBooksWithThumbnailsUseCase = GetBooksWithThumbnailsUseCase(
            booksRepository = booksRepository,
            defaultDispatcher = Dispatchers.Default,
            getBookIdUseCase = getBookIdUseCase,
            setHttpsUseCase = setHttpsUseCase,
        )

        runTest {
            bookshelfViewModel = BookshelfViewModel(
                getBooksWithThumbnailsUseCase = getBooksWithThumbnailsUseCase
            )
        }
    }

    @Test
    fun bookshelfViewModelTest_LoadingSuccess_BookUiStateIsSuccessSuccess() {
        Thread.sleep(300)
        assertTrue(bookshelfViewModel.booksUiState.value is BookShelfUiState.Success)
    }

    @Test
    fun bookshelfViewModelTest_LoadingSuccess_BookUiStateValueCheckSuccess() {
        Thread.sleep(300)
        assertTrue(bookshelfViewModel.booksUiState.value is BookShelfUiState.Success)

        val books = (bookshelfViewModel.booksUiState.value as BookShelfUiState.Success).books
        assertTrue(books.size == 2)

        assertEquals(
            books[0],
            BooksUiModel(id = "id1", title = "title1", url = "thumbnail")
        )
    }
    
    @Test
    fun bookshelfViewModelTest_getBook_BookUiStateValueCheckSuccess() {
        Thread.sleep(300)
        assertTrue(bookshelfViewModel.booksUiState.value is BookShelfUiState.Success)
        bookshelfViewModel.getBooks()
        Thread.sleep(300)
        assertTrue(bookshelfViewModel.booksUiState.value is BookShelfUiState.Success)
    }
}