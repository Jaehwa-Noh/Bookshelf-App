//
//  SetHttpsUseCaseTest.swift
//  Bookshelf appTests
//
//  Created by Jaehwa Noh on 1/29/24.
//

import XCTest
@testable import Bookshelf_app
import Factory

final class SetHttpsUseCaseTest: XCTestCase {

    private var setHttpsUseCase: SetHttpsUseCase?
    
    override func setUpWithError() throws {
        // Put setup code here. This method is called before the invocation of each test method in the class.
        try super.setUpWithError()
        Container.shared.reset()
        Scope.singleton.reset()
        
        setHttpsUseCase = Container.shared.setHttpsUseCase()
    }

    override func tearDownWithError() throws {
        // Put teardown code here. This method is called after the invocation of each test method in the class.
        try super.tearDownWithError()
        setHttpsUseCase = nil
    }

    func test_SetHttpsUseCaseTest_HttpToHttps_HttpsSuccess() async {
        let result = await setHttpsUseCase!(url: "http://")
        XCTAssertEqual("https://", result)
    }
}
