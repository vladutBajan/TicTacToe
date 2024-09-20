package com.example.myticktacktoeAndroid.presentation.players

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.myticktacktoeAndroid.presentation.oldGames.OldGamesEvent

@Composable
fun PlayersScreen(eventHandle: (PlayerEvent) -> Unit) {
    Column(
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier= Modifier.fillMaxSize().padding(30.dp))
    {
        Text(text = "Enter player1 name: ")

        val namePlayer1 = remember { mutableStateOf("player1") }
        TextField(
            value = namePlayer1.value,
            onValueChange = {
                eventHandle(PlayerEvent.OnUpdatePlayerName(1, it))
                namePlayer1.value = it
            })

        Text(text = "Enter player2 name: ")

        val namePlayer2 = remember { mutableStateOf("player2") }
        TextField(
            value = namePlayer2.value,
            onValueChange = {
                eventHandle(PlayerEvent.OnUpdatePlayerName(2, it))
                namePlayer2.value = it
            })

        Button(
            modifier = Modifier
                .padding(10.dp),
            onClick = { eventHandle(PlayerEvent.GoToGame) },
            shape = RoundedCornerShape(20),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.White,
                contentColor = Color.Black
            )
        ) {
            Text("Start game")
        }
    }
}