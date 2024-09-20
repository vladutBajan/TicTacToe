package com.example.myticktacktoeAndroid.data.repositories

class UserRepositoryImpl : UserRepository {
    private var player1Name : String = "Player1"
    private var player2Name : String = "Player2"

    override fun updatePlayer1Name(name: String) { player1Name = name }

    override fun updatePlayer2Name(name: String) { player2Name = name }

    override fun getPlayer1Name(): String = player1Name

    override fun getPlayer2Name(): String = player2Name
}