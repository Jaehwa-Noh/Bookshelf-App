//
//  GoogleBookApiService.swift
//  Bookshelf app
//
//  Created by Jaehwa Noh on 1/27/24.
//

import Foundation
import Alamofire

protocol GoogleBookApiService {
    func getBooks(searchTerm: String) async throws -> GoogleBookApiModel
    func getThumbnail(bookId: String) async throws -> GoogleBookRetrieveApiModel
}

struct GoogleBookApi: GoogleBookApiService {
    
    private let url = URL(string: "https://www.googleapis.com/books/v1")
    
    func getBooks(searchTerm: String) async throws -> GoogleBookApiModel {
        guard let url else {
            throw URLError(.badURL)
        }
        var getBooksUrl = url
        getBooksUrl.append(path: "volumes")
        getBooksUrl.append(queryItems: [URLQueryItem(name: "q", value: searchTerm)])
        
        let response = await AF.request(getBooksUrl)
            .validate()
            .serializingDecodable(GoogleBookApiModel.self)
            .response
        
        switch response.result {
        case let .success(data):
            return data
        case let .failure(error):
            throw error
        }
        
    }
    
    func getThumbnail(bookId: String) async throws -> GoogleBookRetrieveApiModel {
        guard let url else {
            throw URLError(.badURL)
        }
        var getThumbnailUrl = url
        getThumbnailUrl.append(path: "volumes")
        getThumbnailUrl.append(path: bookId)
        
        let response = await AF.request(getThumbnailUrl)
            .validate()
            .serializingDecodable(GoogleBookRetrieveApiModel.self)
            .response
        
        switch response.result {
        case let .success(data):
            return data
        case let .failure(error):
            throw error
        }
    }
    
    
}
