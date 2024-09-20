package com.example.myticktacktoeAndroid.presentation.game

data class GameState (
    val player1Name : String = "Player1",
    val player2Name : String = "Player2",
    val player1Wins : Int = 0,
    val player2Wins : Int = 0,
    val nextPlayer : Int = 0,
    val isGameOver : Int = 0,
    val board: MutableList<Int> = mutableListOf(0,0,0,0,0,0,0,0,0)
)