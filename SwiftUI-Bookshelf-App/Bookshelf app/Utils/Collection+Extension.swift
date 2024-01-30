//
//  Collection+Extension.swift
//  Bookshelf app
//
//  Created by Jaehwa Noh on 1/28/24.
//

extension Collection {
    func asyncMap<T>(
        _ transform: (Element) async throws -> T
    ) async rethrows -> [T] {
        let n = self.count
        if n == 0 {
            return []
        }
        
        var result = ContiguousArray<T>()
        result.reserveCapacity(n)
        
        var i = self.startIndex
        
        for _ in 0..<n {
            await result.append(try transform(self[i]))
            formIndex(after: &i)
        }
        
        return Array(result)
    }
}
