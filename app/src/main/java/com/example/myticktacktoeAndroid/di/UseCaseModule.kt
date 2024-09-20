package com.example.myticktacktoeAndroid.di

import com.example.myticktacktoeAndroid.data.repositories.GameRepository
import com.example.myticktacktoeAndroid.data.repositories.UserRepository
import com.example.myticktacktoeAndroid.domain.usecases.GetOldGamesUseCase
import com.example.myticktacktoeAndroid.domain.usecases.InitGameUseCase
import com.example.myticktacktoeAndroid.domain.usecases.ResetScoreUseCase
import com.example.myticktacktoeAndroid.domain.usecases.UserTappedUseCase

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import io.reactivex.rxjava3.core.Scheduler

@Module
@InstallIn(ActivityRetainedComponent::class)
object UseCaseModule {

    @Provides
    fun providesInitGameUseCase(gameRepository: GameRepository, scheduler: Scheduler): InitGameUseCase {
        return InitGameUseCase(gameRepository, scheduler)
    }

    @Provides
    fun providesUserTappedUseCase(gameRepository: GameRepository, userRepository: UserRepository, scheduler: Scheduler): UserTappedUseCase {
        return UserTappedUseCase(gameRepository, userRepository, scheduler)
    }

    @Provides
    fun providesGetOldGamesUseCase(gameRepository: GameRepository, scheduler: Scheduler): GetOldGamesUseCase {
        return GetOldGamesUseCase(gameRepository, scheduler)
    }

    @Provides
    fun resetScoreUseCase(gameRepository: GameRepository, scheduler: Scheduler): ResetScoreUseCase {
        return ResetScoreUseCase(gameRepository, scheduler)
    }
}