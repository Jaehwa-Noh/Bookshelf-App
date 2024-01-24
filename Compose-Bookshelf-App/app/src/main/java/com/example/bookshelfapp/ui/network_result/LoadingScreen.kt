package com.example.bookshelfapp.ui.network_result

import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun LoadingScreen(
    modifier: Modifier = Modifier
) {
    CircularProgressIndicator(
        modifier = modifier
    )
}