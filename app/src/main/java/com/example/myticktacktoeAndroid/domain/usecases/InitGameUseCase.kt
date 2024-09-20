package com.example.myticktacktoeAndroid.domain.usecases
import com.example.myticktacktoeAndroid.data.repositories.GameRepository
import com.example.myticktacktoeAndroid.domain.models.Game
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Scheduler

import javax.inject.Inject

class InitGameUseCase(
    private val gameRepository: GameRepository,
    private val scheduler: Scheduler
) {
    operator fun invoke() : Observable<Game> {
        gameRepository.initGame()
        return Observable.just(gameRepository.getGame()).subscribeOn(scheduler).observeOn(AndroidSchedulers.mainThread())
    }
}