package com.example.bookshelfapp.ui.network_result

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun ErrorScreen(
    modifier: Modifier = Modifier,
    error: String
) {
    Text(
        text = error,
        modifier = modifier
    )
}