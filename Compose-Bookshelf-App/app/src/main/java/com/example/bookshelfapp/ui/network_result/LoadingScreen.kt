package com.example.bookshelfapp.ui.network_result

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag

@Composable
fun LoadingScreen(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .testTag("tag_loading"),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator()
    }
}