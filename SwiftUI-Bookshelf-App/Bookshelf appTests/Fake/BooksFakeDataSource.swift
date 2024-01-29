//
//  BooksFakeDataSource.swift
//  Bookshelf appTests
//
//  Created by Jaehwa Noh on 1/29/24.
//
@testable import Bookshelf_app

struct BooksFakeDataSource: BooksDataSource {
    func getBooks(searchTerms: String) async throws -> Bookshelf_app.GoogleBookApiModel {
        return GoogleBookApiModel(
            kind: "kind1",
            items: [
                GoogleBookItemsModel(
                    kind: "kind1",
                    id: "id1",
                    eTag: "eTag1",
                    selfLink: "selfLink1",
                    volumeInfo: VolumeInfoModel(
                        title: "title1",
                        authors: ["authors1"])
                ),
                GoogleBookItemsModel(
                    kind: "kind2",
                    id: "id2",
                    eTag: "eTag2",
                    selfLink: "selfLink2",
                    volumeInfo: VolumeInfoModel(
                        title: "title2",
                        authors: ["authors2"])
                )
            ],
            totalItems: 2)
    }
    
    
}

