//
//  GoogleBookRetrieveApiModel.swift
//  Bookshelf app
//
//  Created by Jaehwa Noh on 1/27/24.
//

struct GoogleBookRetrieveApiModel {
    let volumeInfo: RetrieveVolumeInfoModel
}

struct RetrieveVolumeInfoModel {
    let imageLinks: ThumbnailModel?
}

struct ThumbnailModel {
    let thumbnail: String
}
