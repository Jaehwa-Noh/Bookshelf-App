//
//  FactoryContainer.swift
//  Bookshelf app
//
//  Created by Jaehwa Noh on 1/27/24.
//

import Factory

extension Container {
    var bookshelfViewModel: Factory<BookshelfViewModel> {
        self {
            BookshelfViewModel()
        }
    }
    
    var googleBookApiService: Factory<GoogleBookApiService> {
        self {
            GoogleBookApi()
        }
        .singleton
    }
    
    var userInitiated: Factory<TaskPriority> {
        self {
            .userInitiated
        }
    }
}


