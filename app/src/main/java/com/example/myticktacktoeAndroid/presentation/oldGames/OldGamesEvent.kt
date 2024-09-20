package com.example.myticktacktoeAndroid.presentation.oldGames

sealed class OldGamesEvent {
    data object BackToGame : OldGamesEvent()
}