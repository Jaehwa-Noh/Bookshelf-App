package com.example.bookshelfapp.fake

import com.example.bookshelfapp.data.BookThumbnailDataSource
import com.example.bookshelfapp.model.GoogleBookRetrieveApiModel
import com.example.bookshelfapp.model.RetrieveVolumeInfoModel
import com.example.bookshelfapp.model.ThumbnailModel

class ThumbnailFakeDataSource : BookThumbnailDataSource {
    override suspend fun getThumbnails(bookId: String): GoogleBookRetrieveApiModel {
        return GoogleBookRetrieveApiModel(
            volumeInfo = RetrieveVolumeInfoModel(
                imageLinks = ThumbnailModel(
                    thumbnail = "thumbnail"
                )
            )
        )
    }
}