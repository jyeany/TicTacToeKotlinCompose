package services

import kotlin.js.Date
import kotlin.random.Random

class RandomMoveCp : IComputerPlayer {

    private val random = Random(Date().getMilliseconds())

    override fun makeMove(gameBoard: Array<CharArray>): MoveModel {
        val availableMoves = determineAvailableMoves(gameBoard)
        val chosenIndex = random.nextInt(0, availableMoves.size)
        return availableMoves[chosenIndex]
    }

    private fun determineAvailableMoves(gameBoard: Array<CharArray>): List<MoveModel> {
        val availableMoves = mutableListOf<MoveModel>()
        for (i in gameBoard.indices) {
            for (j in 0 until gameBoard[i].size) {
                if (gameBoard[i][j] == '-') {
                    val availableMove = MoveModel(i, j, IComputerPlayer.COMPUTER_CHAR)
                    availableMoves.add(availableMove)
                }
            }
        }
        return availableMoves
    }

}