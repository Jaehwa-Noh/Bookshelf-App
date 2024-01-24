package com.example.bookshelfapp.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bookshelfapp.domain.GetBooksWithThumbnailsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BookshelfViewModel @Inject constructor(
    private val getBooksWithThumbnailsUseCase: GetBooksWithThumbnailsUseCase
) : ViewModel() {
    private var _booksUiState: MutableStateFlow<BookShelfUiState> =
        MutableStateFlow(BookShelfUiState.Loading)

    val booksUiState: StateFlow<BookShelfUiState> = _booksUiState

    init {
        getBooks()
    }

    private fun getBooks() {
        viewModelScope.launch {
            _booksUiState.value = BookShelfUiState.Loading
            _booksUiState.value = try {
                BookShelfUiState.Success(
                    getBooksWithThumbnailsUseCase("다이아몬드는 개똥밭에 굴러도 다이아몬드이다.")
                )
            } catch (e: Error) {
                BookShelfUiState.Error(e.localizedMessage ?: "Error")
            }
        }
    }

}


sealed interface BookShelfUiState {
    data class Success(val books: List<BooksUiModel>) : BookShelfUiState
    data object Loading : BookShelfUiState
    data class Error(val error: String) : BookShelfUiState
}

data class BooksUiModel(
    val id: String,
    val title: String,
    val url: String
)