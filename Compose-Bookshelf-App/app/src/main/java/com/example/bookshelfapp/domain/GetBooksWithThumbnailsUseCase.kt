package com.example.bookshelfapp.domain

import com.example.bookshelfapp.data.BooksRepository
import com.example.bookshelfapp.ui.BooksUiModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetBooksWithThumbnailsUseCase @Inject constructor(
    private val booksRepository: BooksRepository,
    private val defaultDispatcher: CoroutineDispatcher,
    private val getBookIdUseCase: GetBookIdUseCase
) {
    suspend operator fun invoke(searchTerms: String): List<BooksUiModel> {
        return withContext(defaultDispatcher) {
            val books = booksRepository.getBooks(searchTerms = searchTerms)
            val uiBooks = books.items.map { bookModel ->
                val thumbnail =
                    booksRepository
                        .getThumbnails(bookId = getBookIdUseCase(bookModel.selfLink))
                        .volumeInfo
                        .imageLinks
                        .thumbnail

                BooksUiModel(
                    id = bookModel.id,
                    title = bookModel.volumeInfo.title,
                    url = thumbnail
                )
            }
            uiBooks
        }
    }
}