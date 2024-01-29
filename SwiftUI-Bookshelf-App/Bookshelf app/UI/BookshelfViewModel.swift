//
//  BookshelfViewModel.swift
//  Bookshelf app
//
//  Created by Jaehwa Noh on 1/27/24.
//

import SwiftUI
import Factory
import Alamofire

class BookshelfViewModel: ObservableObject {
    @Published var bookShelfUiState: BookshelfUiState = .loading
    @Injected(\.getBooksWithThumbnailUseCase) var getBooksWithThumbnailUseCase
    
    init() {
        getBooks()
    }
    
    func getBooks() {
        Task {
            bookShelfUiState = .loading
            do {
                bookShelfUiState = .success(try await getBooksWithThumbnailUseCase(searchTerms: "다이아몬드는 개똥밭에 굴러도 다이아몬드이다."))
            } catch URLError.badURL {
                bookShelfUiState = .error("Bad Url")
            } catch {
                bookShelfUiState = .error(error.localizedDescription)
            }
        }
    }
}

enum BookshelfUiState {
    case success([BookshelfUiModel])
    case loading
    case error(String)
}

struct BookshelfUiModel {
    let id: String
    let title: String
    let url: String
}
