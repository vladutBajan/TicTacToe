package com.example.myticktacktoeAndroid.presentation.game
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.LiveData
import com.example.myticktacktoeAndroid.data.models.OldGame
import com.example.myticktacktoeAndroid.presentation.oldGames.OldGamesEvent
import com.example.myticktacktoeAndroid.presentation.oldGames.OldGamesState

@Composable
fun OldGamesScreen(oldGameLiveData: LiveData<OldGamesState>, eventHandle: (OldGamesEvent) -> Unit) {
    val state by oldGameLiveData.observeAsState(OldGamesState())

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier= Modifier.fillMaxSize().padding(30.dp)){
        LazyColumn(modifier = Modifier.fillMaxWidth().padding(40.dp)) {
            items(state.oldGames){ oldGame ->
                OldGameRow(oldGame)
            }
        }

        Button(
            onClick = {eventHandle(OldGamesEvent.BackToGame)}) {
            Text("Back to Game")
        }
    }
}

@Composable
fun OldGameRow(oldGame : OldGame){
    Row(modifier = Modifier.fillMaxWidth().height(30.dp)) {
        Text(oldGame.player1 + " " + oldGame.scorePlayer1 + " - " + oldGame.scorePlayer2 + " " + oldGame.player2)
    }
}