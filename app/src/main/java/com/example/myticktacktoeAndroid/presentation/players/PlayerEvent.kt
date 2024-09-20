package com.example.myticktacktoeAndroid.presentation.players

sealed class PlayerEvent {
    data object GoToGame : PlayerEvent()
    data class OnUpdatePlayerName(var playerNumber : Int, var playerName : String) : PlayerEvent()
}