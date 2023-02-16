package com.example.arcxpcodechallenge.di

import com.example.arcxpcodechallenge.framework.networking.WashingtonPostAPI
import com.example.arcxpcodechallenge.repositories.PostsRepository
import com.example.arcxpcodechallenge.repositories.PostsRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module(includes = [APIModule::class])
object RepositoryModule {

    @Provides
    @Singleton
    fun providePostsRepository(
        api: WashingtonPostAPI
    ): PostsRepository = PostsRepositoryImpl(api)

}
