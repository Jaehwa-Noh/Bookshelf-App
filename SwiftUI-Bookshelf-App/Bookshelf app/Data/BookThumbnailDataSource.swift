//
//  BookThumbnailDataSource.swift
//  Bookshelf app
//
//  Created by Jaehwa Noh on 1/28/24.
//

import Factory

protocol BookThumbnailDataSource {
    func getThumbnails(bookId: String) async throws -> GoogleBookRetrieveApiModel
}

struct BookThumbnailNetworkDataSource: BookThumbnailDataSource {
    @Injected(\.googleBookApiService) var googleBookApiService
    @Injected(\.userInitiated) var ioTask
    
    func getThumbnails(bookId: String) async throws -> GoogleBookRetrieveApiModel {
        return try await Task.detached(priority: ioTask) {
            do {
                return try await  googleBookApiService.getThumbnail(bookId: bookId)
            }
        }.result.get()
    }
}
