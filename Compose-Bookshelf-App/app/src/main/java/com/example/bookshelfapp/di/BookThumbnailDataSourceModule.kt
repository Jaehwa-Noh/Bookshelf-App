package com.example.bookshelfapp.di

import com.example.bookshelfapp.data.BookThumbnailDataSource
import com.example.bookshelfapp.data.BookThumbnailNetworkDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class BookThumbnailDataSourceModule {
    @Singleton
    @Binds
    abstract fun bindBookThumbnailDataSource(impl: BookThumbnailNetworkDataSource): BookThumbnailDataSource
}