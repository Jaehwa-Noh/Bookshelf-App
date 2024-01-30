//
//  LoadingView.swift
//  Bookshelf app
//
//  Created by Jaehwa Noh on 1/27/24.
//

import SwiftUI

struct LoadingView: View {
    var body: some View {
        ProgressView()
            .accessibilityIdentifier("LoadingView")
    }
}

#Preview {
    LoadingView()
}
