package com.example.myticktacktoeAndroid.di

import com.example.myticktacktoeAndroid.data.repositories.GameRepository
import com.example.myticktacktoeAndroid.data.repositories.GameRepositoryImpl
import com.example.myticktacktoeAndroid.data.repositories.UserRepositoryImpl
import com.example.myticktacktoeAndroid.data.repositories.UserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Singleton
    @Provides
    fun provideUserRepo() : UserRepository {
        return UserRepositoryImpl()
    }

    @Singleton
    @Provides
    fun provideGameRepo() : GameRepository {
        return GameRepositoryImpl()
    }
}