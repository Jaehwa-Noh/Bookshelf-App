//
//  ThumbnailFakeDataSource.swift
//  Bookshelf appTests
//
//  Created by Jaehwa Noh on 1/29/24.
//

@testable import Bookshelf_app

struct ThumbnailFakeDataSource: BookThumbnailDataSource {
    func getThumbnails(bookId: String) async throws -> Bookshelf_app.GoogleBookRetrieveApiModel {
        return GoogleBookRetrieveApiModel(
            volumeInfo: RetrieveVolumeInfoModel(
                imageLinks: ThumbnailModel(
                    thumbnail: "thumbnail")
            )
        )
    }
}
