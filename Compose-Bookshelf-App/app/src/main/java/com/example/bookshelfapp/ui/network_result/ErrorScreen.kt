package com.example.bookshelfapp.ui.network_result

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.bookshelfapp.ui.theme.BookshelfAppTheme

@Composable
fun ErrorScreen(
    modifier: Modifier = Modifier,
    error: String,
    onRetryButtonClick: () -> Unit
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = error
        )

        Button(onClick = onRetryButtonClick) {
            Text(text = "Retry")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ErrorScreenPreview() {
    BookshelfAppTheme {
        ErrorScreen(error = "Test",
            modifier = Modifier.fillMaxSize(),
            onRetryButtonClick = {})
    }
}