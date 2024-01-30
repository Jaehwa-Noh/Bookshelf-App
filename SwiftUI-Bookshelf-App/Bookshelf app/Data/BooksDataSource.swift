//
//  BooksDataSource.swift
//  Bookshelf app
//
//  Created by Jaehwa Noh on 1/27/24.
//
import Factory

protocol BooksDataSource {
    func getBooks(searchTerms: String) async throws -> GoogleBookApiModel
}

struct BooksNetworkDataSource: BooksDataSource {
    @Injected(\.googleBookApiService) var googleBookApiService
    @Injected(\.userInitiated) var ioTask
    
    func getBooks(searchTerms: String) async throws -> GoogleBookApiModel {
        return try await Task.detached(priority: ioTask) {
            do {
                return try await googleBookApiService.getBooks(searchTerm: searchTerms)
            }
        }.result.get()
    }
    
    
}
