//
//  BookshelfListView.swift
//  Bookshelf app
//
//  Created by Jaehwa Noh on 1/27/24.
//

import SwiftUI
import Factory

struct BookshelfListView: View {
    let books: [BookshelfUiModel]
    let columns = [GridItem(.flexible(), spacing: 0, alignment: .topLeading), GridItem(.flexible(), spacing: 0, alignment: .topLeading)]
    
    var body: some View {
        ScrollView {
            LazyVGrid(columns: columns, spacing: 0) {
                ForEach(books, id: \.id) { book in
                    if book.url.isEmpty {
                        VStack {
                            Text(book.title)
                                .multilineTextAlignment(.leading)
                            Spacer()
                        }
                        .padding([.horizontal], 4)
                        .frame(height: 250)
                    } else {
                        AsyncImage(url: URL(string: book.url)) {
                            image in
                            image.resizable()
                        } placeholder: {
                            ProgressView()
                                .frame(maxWidth: .infinity, maxHeight: 250)
                        }
                        .frame(height: 250)
                    }
                }
            }
        }
    }
}

#Preview {
    BookshelfListView(books: [])
}
