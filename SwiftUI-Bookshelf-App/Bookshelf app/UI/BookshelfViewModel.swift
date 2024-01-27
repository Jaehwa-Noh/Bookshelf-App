//
//  BookshelfViewModel.swift
//  Bookshelf app
//
//  Created by Jaehwa Noh on 1/27/24.
//

import SwiftUI

class BookshelfViewModel: ObservableObject {
    @Published var bookShelfUiState: BookshelfUiState = .loading
    
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
