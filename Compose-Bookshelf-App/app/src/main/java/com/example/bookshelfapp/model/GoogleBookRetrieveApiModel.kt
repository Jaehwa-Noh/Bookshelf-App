package com.example.bookshelfapp.model

import kotlinx.serialization.Serializable

@Serializable
data class GoogleBookRetrieveApiModel(
    val volumeInfo: RetrieveVolumeInfoModel
)

@Serializable
data class RetrieveVolumeInfoModel(
    val imageLinks: ThumbnailModel? = null
)

@Serializable
data class ThumbnailModel(
    val thumbnail: String
)

