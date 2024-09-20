package com.example.myticktacktoeAndroid.domain.usecases

import com.example.myticktacktoeAndroid.data.repositories.GameRepository
import com.example.myticktacktoeAndroid.data.repositories.UserRepository
import com.example.myticktacktoeAndroid.domain.models.Game
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Scheduler

class UserTappedUseCase(
    private val gameRepository: GameRepository,
    private val userRepository: UserRepository,
    private val scheduler: Scheduler
) {
    operator fun invoke(row : Int, column : Int) : Observable<Game> {

    val game = gameRepository.getGame()
    val player = game.playerToGo()

    if(game.isGameFinished() == 0) {
        gameRepository.updateBoard(row, column, player)
    }

    when(gameRepository.getGame().isGameFinished()) {
        1 -> {
            gameRepository.player1Won()
            gameRepository.addOldGame(userRepository.getPlayer1Name(), userRepository.getPlayer2Name())
        }

        2 -> {
            gameRepository.player2Won()
            gameRepository.addOldGame(userRepository.getPlayer1Name(), userRepository.getPlayer2Name())
        }

        3 -> {
            gameRepository.draw()
            gameRepository.addOldGame(userRepository.getPlayer1Name(), userRepository.getPlayer2Name())
        }
    }


    return Observable.just(gameRepository.getGame()).subscribeOn(scheduler).observeOn(
        AndroidSchedulers.mainThread())
    }
}