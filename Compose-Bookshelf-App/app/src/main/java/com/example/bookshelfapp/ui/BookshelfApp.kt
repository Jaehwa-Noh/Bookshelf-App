package com.example.bookshelfapp.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.bookshelfapp.R
import com.example.bookshelfapp.ui.network_result.ErrorScreen
import com.example.bookshelfapp.ui.network_result.LoadingScreen

@Composable
fun BookshelfApp(modifier: Modifier = Modifier) {
    val bookshelfViewModel: BookshelfViewModel = viewModel()
    val bookshelfUiState = bookshelfViewModel.booksUiState.collectAsState()

    Scaffold(
        modifier = modifier,
        topBar = {
            BookshelfAppBar()
        }
    ) {
        when (bookshelfUiState.value) {
            is BookShelfUiState.Error -> ErrorScreen(
                error = (bookshelfUiState.value as BookShelfUiState.Error).error
            )

            is BookShelfUiState.Loading -> LoadingScreen()
            is BookShelfUiState.Success -> BookshelfListScreen(
                modifier = Modifier.padding(it)
            )
        }

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BookshelfAppBar(
    modifier: Modifier = Modifier
) {
    CenterAlignedTopAppBar(
        title = {
            Text(
                stringResource(id = R.string.bookshelf),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                style = MaterialTheme.typography.displaySmall
            )
        },
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        ),
        modifier = modifier
    )
}