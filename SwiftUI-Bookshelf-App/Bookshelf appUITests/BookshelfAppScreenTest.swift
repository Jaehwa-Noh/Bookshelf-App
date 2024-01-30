//
//  BookshelfAppScreenTest.swift
//  Bookshelf appUITests
//
//  Created by Jaehwa Noh on 1/29/24.
//

import XCTest

final class BookshelfAppScreenTest: XCTestCase {
    var app: XCUIApplication?
    
    
    override func setUpWithError() throws {
        try super.setUpWithError()
        // Put setup code here. This method is called before the invocation of each test method in the class.
        
        // In UI tests it is usually best to stop immediately when a failure occurs.
        continueAfterFailure = false
        
        // In UI tests it’s important to set the initial state - such as interface orientation - required for your tests before they run. The setUp method is a good place to do this.
        
        app = XCUIApplication()
        app?.launch()
    }
    
    override func tearDownWithError() throws {
        try super.tearDownWithError()
        // Put teardown code here. This method is called after the invocation of each test method in the class.
        app = nil
    }
    
    func test_LoadingScreen_Loading_ProgressDisplaySuccess() {
        navigateToList()
    }
    
    func test_BookListScreen_ShowList_BooksListDisplaySuccess() {
        navigateToList()
        let myBook = app!.staticTexts["다이아몬드는 개똥밭에 굴러도 다이아몬드이다"]
        XCTAssertTrue(myBook.exists)
    }
    
    func navigateToList() {
        let progressView = app!.activityIndicators["LoadingView"]
        
        let doesNotExistPredicate = NSPredicate(format: "exists == FALSE")
        expectation(for: doesNotExistPredicate, evaluatedWith: progressView, handler: nil)
        waitForExpectations(timeout: 30, handler: nil)
    }
}
