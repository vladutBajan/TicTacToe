package com.example.myticktacktoeAndroid.presentation.game

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.touchlane.gridpad.GridPad
import com.touchlane.gridpad.GridPadCells
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.LiveData

@Composable
fun GameScreen(gameLiveData: LiveData<GameState>, eventHandle: (GameEvent) -> Unit) {
    val state by gameLiveData.observeAsState(GameState())
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier= Modifier.fillMaxSize()) {

        GridPad(
            modifier = Modifier.background(Color.Gray).padding(0.dp, 50.dp).height(300.dp),
            cells = GridPadCells(3, 3)
        ) {
            for (i in 0..2) {
                for (j in 0..2) {
                    item(row = i, column = j) {
                        Button(
                            modifier = Modifier
                                .padding(10.dp)
                                .fillMaxSize(),
                            onClick = { if (state.isGameOver == 0) eventHandle(GameEvent.squareTapped(i,j)) },
                            shape = RoundedCornerShape(20),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color.White,
                                contentColor = Color.Black
                            )
                        ) {
                            val text = remember { mutableStateOf("") }
                            text.value =
                                when (state.board[i * 3 + j]) {
                                    1 -> "X"
                                    2 -> "0"
                                    else -> ""
                                }
                            Text(text = text.value, fontSize = 30.sp, modifier = Modifier.fillMaxSize())
                        }
                    }
                }
            }
        }

        Button(
            modifier = Modifier
                .padding(10.dp).height(50.dp),
            onClick = { eventHandle(GameEvent.RestartTapped) },
            shape = RoundedCornerShape(20),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Green,
                contentColor = Color.Black
            )
        ) {
            Text(text = "Restart")
        }

        val score = remember { mutableStateOf("") }
        score.value = state.player1Name + " " + state.player1Wins + " - " + state.player2Wins + " " + state.player2Name

        Text(text = score.value, modifier = Modifier.height(20.dp))

        val textWhoWon = remember { mutableStateOf("") }
        textWhoWon.value = when (state.isGameOver) {
            0 -> ""
            1 -> state.player1Name + " won!"
            2 -> state.player2Name + " won!"
            3 -> "draw"
            else -> ""
        }

        Text(text = textWhoWon.value, modifier = Modifier.height(20.dp))

        Button(onClick = {eventHandle(GameEvent.AboutTapped)}) {
            Text("About page")
        }

        Button(onClick = {eventHandle(GameEvent.HistoryTapped)}){
            Text("History page")
        }

        Button(onClick = {eventHandle(GameEvent.PlayerEditTapped)}){
            Text("Player name edit")
        }
    }
}