package com.example.myticktacktoeAndroid.data.repositories

import com.example.myticktacktoeAndroid.data.models.OldGame
import com.example.myticktacktoeAndroid.domain.models.Game

interface GameRepository {

    fun getGame() : Game

    fun initGame()

    fun player1Won()
    fun player2Won()
    fun draw()
    fun updateBoard(row: Int, column: Int, player: Int)
    fun updatePlayerWhoStarted(player: Int)
    fun addOldGame(player1Name: String, player2Name: String)
    fun getHistoryGames() : List<OldGame>
    fun resetScore()
}