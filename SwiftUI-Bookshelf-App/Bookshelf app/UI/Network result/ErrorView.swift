//
//  ErrorView.swift
//  Bookshelf app
//
//  Created by Jaehwa Noh on 1/27/24.
//

import SwiftUI

struct ErrorView: View {
    let errorMessage: String
    let onRetryButtonClick: () -> Void
    
    var body: some View {
        VStack {
            Text(errorMessage)
            Spacer()
                .frame(height: 12)
            Button("Retry") {
                onRetryButtonClick()
            }
        }
        
    }
}

#Preview {
    ErrorView(errorMessage: "Hello", onRetryButtonClick: {})
}
