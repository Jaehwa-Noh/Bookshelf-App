//
//  ContentView.swift
//  Bookshelf app
//
//  Created by Jaehwa Noh on 1/27/24.
//

import SwiftUI
import Factory

struct BookshelfApp: View {
    @InjectedObject(\.bookshelfViewModel) var bookshelfViewModel
    
    var body: some View {
        NavigationStack {
            switch bookshelfViewModel.bookShelfUiState {
            case .success(let books):
                BookshelfListView(books: books)
                    .navigationTitle("Book shelf")
            case .loading:
                LoadingView()
                    .navigationTitle("Book shelf")
            case .error(let error):
                ErrorView(errorMessage: error,
                          onRetryButtonClick: bookshelfViewModel.getBooks)
                .navigationTitle("Book shelf")
            }
        }
    }
}

#Preview {
    BookshelfApp()
}
