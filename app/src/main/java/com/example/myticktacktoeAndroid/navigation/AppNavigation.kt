package com.example.pictureit.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myticktacktoeAndroid.presentation.about.AboutScreen
import com.example.myticktacktoeAndroid.presentation.about.AboutScreenEvent
import com.example.myticktacktoeAndroid.presentation.game.AboutViewModel
import com.example.myticktacktoeAndroid.presentation.game.GameEvent
import com.example.myticktacktoeAndroid.presentation.game.GameScreen
import com.example.myticktacktoeAndroid.presentation.game.GameViewModel
import com.example.myticktacktoeAndroid.presentation.game.OldGamesScreen
import com.example.myticktacktoeAndroid.presentation.game.OldGamesViewModel
import com.example.myticktacktoeAndroid.presentation.oldGames.OldGamesEvent
import com.example.myticktacktoeAndroid.presentation.players.PlayerEvent
import com.example.myticktacktoeAndroid.presentation.players.PlayersScreen
import com.example.myticktacktoeAndroid.presentation.players.PlayersViewModel
import kotlinx.serialization.Serializable

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = PlayersScreen){
        composable<PlayersScreen>{

            val model = hiltViewModel<PlayersViewModel>()
            PlayersScreen(
                eventHandle = { event : PlayerEvent ->
                    when (event) {
                        is PlayerEvent.OnUpdatePlayerName -> {
                            model.UpdatePlayersName(event.playerNumber, event.playerName)
                        }

                        is PlayerEvent.GoToGame -> {
                            navController.navigate(GameScreen)
                        }
                    }
                }
            )
        }

        composable<GameScreen>{
            val model = hiltViewModel<GameViewModel>()
            GameScreen(
                model.getGameLiveData(),
                eventHandle = { event : GameEvent ->
                    when(event){
                        is GameEvent.squareTapped -> {
                            model.onUserTapped(event.row, event.column)
                        }
                        is GameEvent.AboutTapped -> {
                            navController.navigate(AboutScreen)
                        }
                        is GameEvent.HistoryTapped -> {
                            navController.navigate(OldGamesScreen)
                        }
                        is GameEvent.RestartTapped -> {
                            model.restart()
                        }
                        is GameEvent.PlayerEditTapped -> {
                            model.resetScore()
                            navController.navigate(PlayersScreen)
                        }
                    }
                })
        }

        composable<AboutScreen>{
            val model = hiltViewModel<AboutViewModel>()
            AboutScreen(
                model.getAboutLiveData(),
               eventHandle = {event: AboutScreenEvent ->
                   when(event){
                       is AboutScreenEvent.BackToGame -> {
                           navController.navigate(GameScreen)
                       }
                   }
               }
            )
        }

        composable<OldGamesScreen>{
            val model = hiltViewModel<OldGamesViewModel>()
            OldGamesScreen(
                model.getOldGamesLiveData(),
                eventHandle = {event: OldGamesEvent ->
                    when(event){
                        is OldGamesEvent.BackToGame -> {
                            navController.navigate(GameScreen)
                        }
                    }
                }
            )
        }
    }
}

@Serializable
object GameScreen

@Serializable
object PlayersScreen

@Serializable
object AboutScreen

@Serializable
object OldGamesScreen