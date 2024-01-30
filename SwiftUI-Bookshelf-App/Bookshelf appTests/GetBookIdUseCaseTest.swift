//
//  GetBookIdUseCaseTest.swift
//  Bookshelf appTests
//
//  Created by Jaehwa Noh on 1/29/24.
//

import XCTest
@testable import Bookshelf_app
import Factory

final class GetBookIdUseCaseTest: XCTestCase {

    private var getBookIdUseCase: GetBookIdUseCase?
    
    override func setUpWithError() throws {
        // Put setup code here. This method is called before the invocation of each test method in the class.
        try super.setUpWithError()
        Container.shared.reset()
        Scope.singleton.reset()
        
        getBookIdUseCase = Container.shared.getBooIdUseCase()
    }

    override func tearDownWithError() throws {
        // Put teardown code here. This method is called after the invocation of each test method in the class.
        try super.tearDownWithError()
        getBookIdUseCase = nil
    }

    func test_GetBookIdUseCaseTest_GetBookId_GetBookIdSuccess() async throws {
        let bookId = try await getBookIdUseCase!(url: "Https://fake.com/fake")
        XCTAssertEqual("fake", bookId)
    }
    

}
