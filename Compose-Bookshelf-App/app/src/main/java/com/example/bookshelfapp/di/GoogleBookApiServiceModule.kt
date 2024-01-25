package com.example.bookshelfapp.di

import com.example.bookshelfapp.network.GoogleBookApi
import com.example.bookshelfapp.network.GoogleBookApiService
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class GoogleBookApiServiceModule {

    @Binds
    @Singleton
    abstract fun bindGoogleBookApi(impl: GoogleBookApi): GoogleBookApiService
}