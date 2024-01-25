package com.example.bookshelfapp

import androidx.activity.compose.setContent
import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.hasTestTag
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.bookshelfapp.ui.BookshelfApp
import com.example.bookshelfapp.ui.theme.BookshelfAppTheme
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */

@HiltAndroidTest
@RunWith(AndroidJUnit4::class)
class BookshelfAppScreenTest {
    @get:Rule(order = 0)
    val hiltRule = HiltAndroidRule(this)

    @get:Rule(order = 1)
    var composeTestRule = createAndroidComposeRule<MainActivity>()

    @Before
    fun createBookshelfAppScreen() {
        hiltRule.inject()
        composeTestRule.activity.setContent {
            BookshelfAppTheme {
                BookshelfApp()
            }
        }
    }

    @OptIn(ExperimentalTestApi::class)
    @Test
    fun loadingScreen_Loading_ProgressDisplaySuccess() {
        composeTestRule.waitUntilAtLeastOneExists(
            hasTestTag("tag_loading"), 10_000L
        )
    }


}