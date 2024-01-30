//
//  GoogleBookApiModel.swift
//  Bookshelf app
//
//  Created by Jaehwa Noh on 1/27/24.
//

struct GoogleBookApiModel: Decodable {
    let kind: String
    let items: [GoogleBookItemsModel]
    let totalItems: Int
}

struct GoogleBookItemsModel: Decodable {
    let kind: String
    let id: String
    let eTag: String
    let selfLink: String
    let volumeInfo: VolumeInfoModel
    
    enum CodingKeys: String, CodingKey {
        case kind
        case id
        case eTag = "etag"
        case selfLink
        case volumeInfo
    }
}

struct VolumeInfoModel: Decodable {
    let title: String
    let authors: [String]?
}
