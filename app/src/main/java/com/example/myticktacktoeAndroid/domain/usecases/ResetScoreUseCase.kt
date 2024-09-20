package com.example.myticktacktoeAndroid.domain.usecases

import com.example.myticktacktoeAndroid.data.repositories.GameRepository
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Scheduler

class ResetScoreUseCase(
    private val gameRepository: GameRepository,
    private val scheduler: Scheduler) {

    operator fun invoke() : Observable<Unit> {
        return Observable.just(gameRepository.resetScore()).subscribeOn(scheduler).observeOn(
            AndroidSchedulers.mainThread())
    }
}