package com.example.myticktacktoeAndroid.data.repositories

interface UserRepository {
    fun updatePlayer1Name(name : String)

    fun updatePlayer2Name(name : String)

    fun getPlayer1Name() : String

    fun getPlayer2Name() : String
}