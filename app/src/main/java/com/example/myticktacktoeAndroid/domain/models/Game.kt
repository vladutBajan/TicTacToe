package com.example.myticktacktoeAndroid.domain.models

class Game(var player1GamesWon : Int = 0,
           var player2GamesWon : Int = 0,
           var totalGamesPlayed : Int = 0,
           val board : MutableList<Int> = mutableListOf(0,0,0,0,0,0,0,0,0),
           var playerWhoStarted : Int = -1){

    // 1 -> player1 won, 2->player2 won, 0 -> game in progress, 3 -> draw
    fun isGameFinished(): Int{
        var whoWon = 0
        if(board[0] == board[1] && board[1] == board[2] && board[1] != 0) {
            whoWon = if(board[1] == 1) 1 else 2
        }
        if(board[3] == board[4] && board[4] == board[5] && board[4] != 0) {
            whoWon = if(board[4] == 1) 1 else 2
        }
        if(board[6] == board[7] && board[7] == board[8] && board[7] != 0) {
            whoWon = if(board[7] == 1) 1 else 2
        }


        if(board[0] == board[3] && board[3] == board[6] && board[3] != 0) {
            whoWon = if(board[3] == 1) 1 else 2
        }
        if(board[1] == board[4] && board[4] == board[7] && board[4] != 0) {
            whoWon = if(board[4] == 1) 1 else 2
        }
        if(board[2] == board[5] && board[5] == board[8] && board[5] != 0) {
            whoWon = if(board[5] == 1) 1 else 2
        }


        if(board[0] == board[4] && board[4] == board[8] && board[4] != 0) {
            whoWon = if(board[4] == 1) 1 else 2
        }
        if(board[2] == board[4] && board[4] == board[6] && board[4] != 0) {
            whoWon = if(board[4] == 1) 1 else 2
        }

        if(whoWon == 1){
            return 1
        }

        if(whoWon == 2){
            return 2
        }

        if(board.all { it != 0 }) {
            return 3
        }
        return 0
    }

    fun playerToGo() : Int{
        if(board.all{it == 0}){
            if(totalGamesPlayed % 2 == 0) {
                playerWhoStarted = 1
                return 1
            } else {
                playerWhoStarted = 2
                return 2
            }
        } else {
            if (playerWhoStarted == 1){
                if(board.count { it == 1 } == board.count { it == 2 } ){
                    return 1
                } else {
                    return 2
                }
            }
            else{
                if (board.count { it == 1 } == board.count { it == 2 } ){
                    return 2
                } else {
                    return 1
                }
            }
        }
    }
}