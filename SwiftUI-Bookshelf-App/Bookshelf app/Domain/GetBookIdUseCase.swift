//
//  GetBookIdUseCase.swift
//  Bookshelf app
//
//  Created by Jaehwa Noh on 1/28/24.
//

import Factory

struct GetBookIdUseCase {
    @Injected(\.background) var backgroundTask
    
    func callAsFunction(url: String) async throws -> String {
        return await Task.detached(priority: backgroundTask) {
            let id = url.split(separator: "/").last
            return String(id ?? "")
        }.value
    }
}
