package com.example.bookshelfapp.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GoogleBookApiModel(
    val kind: String,
    val items: List<GoogleBookItemsModel>,
    val totalItems: Int
)

@Serializable
data class GoogleBookItemsModel(
    val kind: String,
    val id: String,
    @SerialName("etag")
    val eTag: String,
    val selfLink: String,
    val volumeInfo: VolumeInfoModel
)

@Serializable
data class VolumeInfoModel(
    val title: String,
    val authors: List<String>
)
