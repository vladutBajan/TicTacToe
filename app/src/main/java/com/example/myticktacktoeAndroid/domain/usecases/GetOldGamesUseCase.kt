package com.example.myticktacktoeAndroid.domain.usecases

import com.example.myticktacktoeAndroid.data.models.OldGame
import com.example.myticktacktoeAndroid.data.repositories.GameRepository
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Scheduler

class GetOldGamesUseCase (
    private val gameRepository: GameRepository,
    private val scheduler: Scheduler
) {
    operator fun invoke() : Observable<List<OldGame>> {
        return Observable.just(gameRepository.getHistoryGames()).subscribeOn(scheduler).observeOn(
            AndroidSchedulers.mainThread())
    }
}