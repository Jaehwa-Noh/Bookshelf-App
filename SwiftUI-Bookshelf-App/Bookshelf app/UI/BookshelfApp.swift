//
//  ContentView.swift
//  Bookshelf app
//
//  Created by Jaehwa Noh on 1/27/24.
//

import SwiftUI

struct BookshelfApp: View {
    var body: some View {
        NavigationStack {
            BookshelfListView()
            .navigationTitle("Book shelf")
        }
    }
}

#Preview {
    BookshelfApp()
}
