//
//  SetHttpsUseCase.kt.swift
//  Bookshelf app
//
//  Created by Jaehwa Noh on 1/28/24.
//

import Factory

struct SetHttpsUseCase {
    @Injected(\.background) var backgroundTask
    
    func callAsFunction(url: String) async -> String {
        return await Task.detached(priority: backgroundTask) {
            var changeUrl = url
            changeUrl.replace("http", with: "https")
            return changeUrl
        }.value
    }
}
