//
//  BooksRepository.swift
//  Bookshelf app
//
//  Created by Jaehwa Noh on 1/28/24.
//

import Factory

struct BooksRepository {
    @Injected(\.booksDataSource) var booksDataSource
    @Injected(\.bookThumbnailDataSource) var bookThumbnailDataSource
    
    func getBooks(searchTerms: String) async throws -> GoogleBookApiModel {
        try await booksDataSource.getBooks(searchTerms: searchTerms)
    }
    
    func getThumbnail(bookId: String) async throws -> GoogleBookRetrieveApiModel {
        try await bookThumbnailDataSource.getThumbnails(bookId: bookId)
    }
}
