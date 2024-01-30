//
//  GoogleBookRetrieveApiModel.swift
//  Bookshelf app
//
//  Created by Jaehwa Noh on 1/27/24.
//

struct GoogleBookRetrieveApiModel: Decodable {
    let volumeInfo: RetrieveVolumeInfoModel
}

struct RetrieveVolumeInfoModel: Decodable {
    let imageLinks: ThumbnailModel?
}

struct ThumbnailModel: Decodable {
    let thumbnail: String
}
