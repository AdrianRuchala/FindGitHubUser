package com.example.findgithubuser.di

import com.example.findgithubuser.data.remote.GitHubApi
import com.example.findgithubuser.data.repository.AppRepositoryImpl
import com.example.findgithubuser.domain.repository.AppRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    @Singleton
    fun provideAppRepository(api: GitHubApi): AppRepository {
        return AppRepositoryImpl(api)
    }
}