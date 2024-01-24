package com.example.bookshelfapp.di

import com.example.bookshelfapp.data.BooksDataSource
import com.example.bookshelfapp.data.BooksNetworkDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class BooksDataSourceModule {
    @Binds
    @Singleton
    abstract fun bindBooksDataSourceModule(impl: BooksNetworkDataSource): BooksDataSource
}