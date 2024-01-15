package com.example.bookshelfapp.network

import io.ktor.client.HttpClient
import io.ktor.client.engine.okhttp.OkHttp
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.request.get
import io.ktor.http.URLProtocol
import io.ktor.http.path
import javax.inject.Inject
import javax.inject.Singleton

interface GoogleBookApiService {
    suspend fun getBooks(searchTerms: String)
}

@Singleton
class GoogleBookApi @Inject constructor() : GoogleBookApiService {
//    private val baseUrl = "https://www.googleapis.com/books/v1/volumes?q=search+terms"
    private val client = HttpClient(OkHttp) {
        defaultRequest {
            url {
                protocol = URLProtocol.HTTPS
                host = "https://www.googleapis.com/books/v1"
            }
        }
    }

    override suspend fun getBooks(searchTerms: String) {
        val response = client.get {
            url {
                path("volumes")
                parameters.append("q", searchTerms)
            }
        }
    }
}