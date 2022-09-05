package services

class GameManager {

    companion object {
        const val rows: Int = 3
        const val cols: Int = 3
    }

    val gameBoard = Array(rows) { CharArray(cols) }
    var currentPlayer = 'X'
    var gameWinner: Char? = null
    private val gameWinDetector = GameWinDetector()

    init {
        for (i in 0..2) {
            for (j in 0..2) {
                gameBoard[i][j] = '-'
            }
        }
    }

    fun playSquare(i: Int, j: Int): Char {
        gameBoard[i][j] = currentPlayer
        val winner = gameWinDetector.gameWinner(gameBoard)
        return if (winner == null) {
            currentPlayer = if (currentPlayer == 'X') 'O' else 'X'
            gameBoard[i][j]
        } else {
            println("Game Won")
            this.gameWinner = winner
            winner
        }
    }

}
