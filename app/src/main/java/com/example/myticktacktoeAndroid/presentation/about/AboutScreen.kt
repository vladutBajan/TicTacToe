package com.example.myticktacktoeAndroid.presentation.about

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.LiveData

@Composable
fun AboutScreen(aboutLiveData: LiveData<AboutState>, eventHandle: (AboutScreenEvent) -> Unit){
    val state by aboutLiveData.observeAsState(AboutState())

    Column(
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier= Modifier.fillMaxSize().padding(30.dp)) {

        Text("App version : " + state.buildVersion)

        Text("Email: vlad.bajan@accenture.com")

        Button(
            onClick = {eventHandle(AboutScreenEvent.BackToGame)}
        ){
            Text("Back to game")
        }
    }
}