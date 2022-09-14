package services

import services.players.*

class GameManager {

    companion object {
        const val rows: Int = 3
        const val cols: Int = 3
    }

    val gameBoard = Array(rows) { CharArray(cols) }
    var currentPlayer = 'X'
    var gameWinner = GameWinner.NONE
    private var computerPlayer: IComputerPlayer = NoopCp()
    private val gameWinDetector = GameWinDetector()

    init {
        resetGameBoard()
    }

    fun playSquare(i: Int, j: Int): Char {
        gameBoard[i][j] = currentPlayer
        val winner = gameWinDetector.gameWinner(gameBoard)
        return if (winner == GameWinner.NONE) {
            switchCurrentPlayer()
            gameBoard[i][j]
        } else {
            this.gameWinner = winner
            winnerToChar(winner)
        }
    }

    fun setGameMode(gameMode: GameMode) {
        this.computerPlayer = when(gameMode) {
            GameMode.OFF -> NoopCp()
            GameMode.RANDOM -> RandomMoveCp()
            GameMode.TO_WIN -> ToWinCp()
        }
    }

    fun computerPlaySquare(): MoveModel {
        val move = computerPlayer.makeMove(gameBoard)
        gameBoard[move.x][move.y] = move.c
        val winner = gameWinDetector.gameWinner(gameBoard)
        if (winner == GameWinner.NONE) {
            switchCurrentPlayer()
        } else {
            this.gameWinner = winner
        }
        return move
    }

    fun resetGame() {
        resetGameBoard()
        currentPlayer = 'X'
        gameWinner = GameWinner.NONE
        computerPlayer = NoopCp()
    }

    fun hasComputerPlayer(): Boolean = computerPlayer !is NoopCp

    private fun switchCurrentPlayer() {
        currentPlayer = if (currentPlayer == 'X') 'O' else 'X'
    }

    private fun resetGameBoard() {
        for (i in 0..2) {
            for (j in 0..2) {
                gameBoard[i][j] = '-'
            }
        }
    }

}
