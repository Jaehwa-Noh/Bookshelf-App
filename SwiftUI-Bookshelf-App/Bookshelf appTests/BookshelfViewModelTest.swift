//
//  BookshelfViewModelTest.swift
//  Bookshelf appTests
//
//  Created by Jaehwa Noh on 1/29/24.
//

import XCTest
@testable import Bookshelf_app
import Factory

final class BookshelfViewModelTest: XCTestCase {
    private var bookshelfViewModel: BookshelfViewModel?
    
    override func setUpWithError() throws {
        // Put setup code here. This method is called before the invocation of each test method in the class.
        try super.setUpWithError()
        Container.shared.reset()
        Scope.singleton.reset()
        
        Container.shared.bookThumbnailDataSource.register {
            ThumbnailFakeDataSource()
        }
        
        Container.shared.booksDataSource.register {
            BooksFakeDataSource()
        }
        
        bookshelfViewModel = Container.shared.bookshelfViewModel()
    }
    
    override func tearDownWithError() throws {
        // Put teardown code here. This method is called after the invocation of each test method in the class.
        try super.tearDownWithError()
        bookshelfViewModel = nil
    }
    
    
    func test_BookshelfViewModelTest_LoadingSuccess_BookshelfUiStateIsSuccessSuccess() async throws {
        
        try await waitLoadData()
        
        guard case let .success(books: books) = bookshelfViewModel!.bookShelfUiState else {
            XCTFail()
            return
        }

        XCTAssertEqual(books.count, 2)
        XCTAssertEqual(books[0], BookshelfUiModel(id: "id1", title: "title1", url: "thumbnail"))
        
    }
    
    func test_BookshelfViewModelTest_getBook_BookUiStateValueCheckSuccess() async throws {
        try await waitLoadData()
        guard case .success(books: _) = bookshelfViewModel!.bookShelfUiState else {
            XCTFail()
            return
        }
        try await waitLoadData()
        guard case let .success(books: books) = bookshelfViewModel!.bookShelfUiState else {
            XCTFail()
            return
        }
        
        XCTAssertEqual(books.count, 2)
        XCTAssertEqual(books[0], BookshelfUiModel(id: "id1", title: "title1", url: "thumbnail"))
    }
    
    
    private func waitLoadData() async throws{
        try await Task.sleep(nanoseconds: 500_000_000)
    }
}
