package services

class GameManager {

    companion object {
        const val rows: Int = 3
        const val cols: Int = 3
    }

    val gameBoard = Array(rows) { CharArray(cols) }
    var currentPlayer = 'X'

    init {
        for (i in 0..2) {
            for (j in 0..2) {
                gameBoard[i][j] = '-'
            }
        }
    }

    fun playSquare(i: Int, j: Int): Char {
        gameBoard[i][j] = currentPlayer
        currentPlayer = if (currentPlayer == 'X') 'O' else 'X'
        return gameBoard[i][j]
    }

}
