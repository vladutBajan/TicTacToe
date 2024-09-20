package com.example.myticktacktoeAndroid.presentation.players

import androidx.lifecycle.ViewModel
import com.example.myticktacktoeAndroid.data.repositories.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel()
class PlayersViewModel @Inject constructor(private val userRepository: UserRepository): ViewModel() {

    fun UpdatePlayersName(playerNumber: Int, playerName : String){
        if(playerNumber == 1){
            userRepository.updatePlayer1Name(playerName)
        }
        if(playerNumber == 2){
            userRepository.updatePlayer2Name(playerName)
        }
    }
}