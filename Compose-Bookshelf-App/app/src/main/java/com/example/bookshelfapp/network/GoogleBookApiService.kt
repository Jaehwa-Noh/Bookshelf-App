package com.example.bookshelfapp.network

import com.example.bookshelfapp.model.GoogleBookApiModel
import com.example.bookshelfapp.model.GoogleBookRetrieveApiModel
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.okhttp.OkHttp
import io.ktor.client.plugins.ResponseException
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.request.get
import io.ktor.http.URLProtocol
import io.ktor.http.appendPathSegments
import io.ktor.http.path
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import javax.inject.Inject
import javax.inject.Singleton

interface GoogleBookApiService {
    suspend fun getBooks(searchTerms: String): GoogleBookApiModel
    suspend fun getThumbnails(bookId: String): GoogleBookRetrieveApiModel
}

@Singleton
class GoogleBookApi @Inject constructor() : GoogleBookApiService {
    private val client = HttpClient(OkHttp) {
        install(ContentNegotiation) {
            json(
                Json {
                    ignoreUnknownKeys = true
                }
            )
        }
        defaultRequest {
            url {
                protocol = URLProtocol.HTTPS
                host = "https://www.googleapis.com/books/v1"
            }
        }
        expectSuccess = true
    }

    override suspend fun getBooks(searchTerms: String): GoogleBookApiModel {
        val httpResponse = try {
            client.get {
                url {
                    path("volumes")
                    parameters.append("q", searchTerms)
                }
            }
        } catch (cause: ResponseException) {
            throw cause
        }

        return httpResponse.body<GoogleBookApiModel>()
    }

    override suspend fun getThumbnails(bookId: String): GoogleBookRetrieveApiModel {
        val httpResponse = try {
            client.get {
                url {
                    appendPathSegments("volumes", bookId)
                }
            }
        } catch (cause: ResponseException) {
            throw cause
        }
        return httpResponse.body<GoogleBookRetrieveApiModel>()
    }
}