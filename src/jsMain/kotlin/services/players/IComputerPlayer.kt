package services.players

import services.MoveModel

interface IComputerPlayer {

    companion object {
        val COMPUTER_CHAR = 'O'
    }

    fun makeMove(gameBoard: Array<CharArray>): MoveModel

}