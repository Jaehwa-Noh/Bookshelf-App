//
//  GetBooksWithThumbnailsUseCaseTest.swift
//  Bookshelf appTests
//
//  Created by Jaehwa Noh on 1/29/24.
//

import XCTest
@testable import Bookshelf_app
import Factory

final class GetBooksWithThumbnailsUseCaseTest: XCTestCase {

    private var getBooksWithThumbnailsUseCase: GetBooksWithThumbnailUseCase?
    
    override func setUpWithError() throws {
        // Put setup code here. This method is called before the invocation of each test method in the class.
        try super.setUpWithError()
        Container.shared.reset()
        Scope.singleton.reset()
        
        Container.shared.booksDataSource.register {
            BooksFakeDataSource()
        }
        
        Container.shared.bookThumbnailDataSource.register {
            ThumbnailFakeDataSource()
        }
        
        getBooksWithThumbnailsUseCase = Container.shared.getBooksWithThumbnailUseCase()
    }

    override func tearDownWithError() throws {
        // Put teardown code here. This method is called after the invocation of each test method in the class.
        try super.tearDownWithError()
        getBooksWithThumbnailsUseCase = nil
    }
    
    func test_GetBooksWithThumbnailUseCaseTest_GetBooksWithThumbnail_GetBooksWithThumbnailSuccess() async throws {
        let books = try await getBooksWithThumbnailsUseCase!(searchTerms: "fake")
        XCTAssertEqual(books[0], BookshelfUiModel(id: "id1", title: "title1", url: "thumbnail"))
    }
}
