package com.example.bookshelfapp.ui

import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun BookshelfListScreen(
    modifier: Modifier = Modifier,
    books: List<BooksUiModel>
) {
    LazyVerticalGrid(
        modifier = modifier,
        columns = GridCells.Fixed(2)
    ) {
        items(count = books.size, key = { books[it].id }) { index ->
            val book = books[index]
            Text(book.title)
        }
    }
}