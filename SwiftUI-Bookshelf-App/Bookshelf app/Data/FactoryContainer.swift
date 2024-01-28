//
//  FactoryContainer.swift
//  Bookshelf app
//
//  Created by Jaehwa Noh on 1/27/24.
//

import Factory

extension Container {
    var getBooksWithThumbnailUseCase: Factory<GetBooksWithThumbnailUseCase> {
        self {
            GetBooksWithThumbnailUseCase()
        }
    }
    
    var getBooIdUseCase: Factory<GetBookIdUseCase> {
        self {
            GetBookIdUseCase()
        }
    }
    
    var setHttpsUseCase: Factory<SetHttpsUseCase> {
        self {
            SetHttpsUseCase()
        }
    }
    
    var booksRepository: Factory<BooksRepository> {
        self {
            BooksRepository()
        }
        .singleton
    }
    
    var bookThumbnailDataSource: Factory<BookThumbnailDataSource> {
        self {
            BookThumbnailNetworkDataSource()
        }
        .singleton
    }
    
    var booksDataSource: Factory<BooksDataSource> {
        self {
            BooksNetworkDataSource()
        }
        .singleton
    }
    
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
    
    var background: Factory<TaskPriority> {
        self {
            .background
        }
    }
}


