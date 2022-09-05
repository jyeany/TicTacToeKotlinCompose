package services

interface IComputerPlayer {

    companion object {
        val COMPUTER_CHAR = 'O'
    }

    fun makeMove(gameBoard: Array<CharArray>): MoveModel

}