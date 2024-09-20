package com.example.myticktacktoeAndroid.presentation.game


sealed class GameEvent {
    data object AboutTapped : GameEvent()
    data object RestartTapped : GameEvent()
    data object HistoryTapped : GameEvent()
    data object PlayerEditTapped : GameEvent()
    data class squareTapped(var row : Int, var column : Int) : GameEvent()
}