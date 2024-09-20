package com.example.myticktacktoeAndroid.data.repositories

import androidx.compose.runtime.currentCompositionErrors
import com.example.myticktacktoeAndroid.data.models.OldGame
import com.example.myticktacktoeAndroid.domain.models.Game

class GameRepositoryImpl() : GameRepository {

    var currentGame : Game = Game()

    val oldGames : MutableList<OldGame> = mutableListOf()


    override fun getGame(): Game {
        return currentGame
    }

    override fun initGame() {
        for(i in 0..8){
            currentGame.board[i] = 0
        }
    }

    override fun player1Won(){
        currentGame.totalGamesPlayed++
        currentGame.player1GamesWon++
    }

     override fun player2Won(){
        currentGame.totalGamesPlayed++
        currentGame.player2GamesWon++
    }

    override fun draw(){
        currentGame.totalGamesPlayed++
    }

    override fun updateBoard(row: Int, column : Int, player : Int) {
        if(currentGame.board[row * 3 + column] == 0)
            currentGame.board[row * 3 + column] = player
    }

    override fun updatePlayerWhoStarted(player: Int){
        currentGame.playerWhoStarted = player
    }

    override fun addOldGame(player1Name: String, player2Name: String) {
        oldGames.add(OldGame(player1Name, player2Name, currentGame.player1GamesWon, currentGame.player2GamesWon))
    }

    override fun getHistoryGames(): List<OldGame> {
        return oldGames
    }

    override fun resetScore() {
        currentGame.player1GamesWon = 0
        currentGame.totalGamesPlayed = 0
        currentGame.player2GamesWon = 0
    }
}