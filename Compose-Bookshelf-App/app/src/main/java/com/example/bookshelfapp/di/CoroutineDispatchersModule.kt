package com.example.bookshelfapp.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

@Module
@InstallIn(SingletonComponent::class)
object CoroutineDispatchersModule {

    @DispatcherIO
    @Provides
    fun provideCoroutineIO(): CoroutineDispatcher {
        return Dispatchers.IO
    }

    @DispatcherDefault
    @Provides
    fun provideCoroutineDefault(): CoroutineDispatcher {
        return Dispatchers.Default
    }
}