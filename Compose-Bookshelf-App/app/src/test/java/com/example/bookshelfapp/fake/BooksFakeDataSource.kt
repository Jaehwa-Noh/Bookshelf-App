package com.example.bookshelfapp.fake

import com.example.bookshelfapp.data.BooksDataSource
import com.example.bookshelfapp.model.GoogleBookApiModel
import com.example.bookshelfapp.model.GoogleBookItemsModel
import com.example.bookshelfapp.model.VolumeInfoModel

class BooksFakeDataSource : BooksDataSource {
    override suspend fun getBooks(searchTerms: String): GoogleBookApiModel {
        return GoogleBookApiModel(
            kind = "kind1",
            items = listOf(
                GoogleBookItemsModel(
                    "kind1",
                    id = "id1",
                    eTag = "eTag1",
                    selfLink = "selfLink1",
                    volumeInfo = VolumeInfoModel(
                        title = "title1",
                        authors = listOf("autors1")
                    )
                ),
                GoogleBookItemsModel(
                    "kind2",
                    id = "id2",
                    eTag = "eTag2",
                    selfLink = "selfLink2",
                    volumeInfo = VolumeInfoModel(
                        title = "title2",
                        authors = listOf("autors2")
                    )
                ),
            ),
            totalItems = 2
        )
    }
}