//
//  GetBooksWithThumbnail.swift
//  Bookshelf app
//
//  Created by Jaehwa Noh on 1/27/24.
//

import Factory

struct GetBooksWithThumbnailUseCase {
    @Injected(\.booksRepository) var booksRepository
    @Injected(\.background) var backgroundTask
    @Injected(\.setHttpsUseCase) var setHttpsUseCase
    @Injected(\.getBooIdUseCase) var getBookIdUseCase
    
    func callAsFunction(searchTerms: String) async throws -> [BookshelfUiModel] {
        try await Task.detached(priority: backgroundTask) {
            let books = try await booksRepository.getBooks(searchTerms: searchTerms)
            
            let uiBooks: [BookshelfUiModel] = try await books.items.asyncMap { bookModel in
                let bookId = try await getBookIdUseCase(url: bookModel.selfLink)
                var thumbnail = try await booksRepository.getThumbnail(bookId: bookId).volumeInfo.imageLinks?.thumbnail ?? ""
                thumbnail = await setHttpsUseCase(url: thumbnail)
                return BookshelfUiModel(id: bookModel.id, title: bookModel.volumeInfo.title, url: thumbnail)
            }
            
            return uiBooks
        }.value
        
    }
}
