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
            await MainActor.run {
                bookShelfUiState = .loading
            }
            do {
                let result: BookshelfUiState = .success(try await getBooksWithThumbnailUseCase(searchTerms: "다이아몬드는 개똥밭에 굴러도 다이아몬드이다."))
                await MainActor.run {
                    bookShelfUiState = result
                }
            } catch URLError.badURL {
                await MainActor.run {
                    bookShelfUiState = .error("Bad Url")
                }
            } catch {
                await MainActor.run {
                    bookShelfUiState = .error(error.localizedDescription)
                }
            }
        }
    }
}

enum BookshelfUiState {
    case success([BookshelfUiModel])
    case loading
    case error(String)
}

struct BookshelfUiModel: Hashable {
    let id: String
    let title: String
    let url: String
}
