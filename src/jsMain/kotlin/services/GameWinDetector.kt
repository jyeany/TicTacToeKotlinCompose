package services

class GameWinDetector {

    private val THREE = 3

    fun gameWinner(gameBoard: Array<CharArray>): Char? {
        val diagonal = checkDiagonal(gameBoard)
        return checkHorizontal(gameBoard)
            ?: (checkVertical(gameBoard)
                ?: diagonal)
    }
    
    private fun checkHorizontal(gameBoard: Array<CharArray>): Char? {
        var winner: Char? = null
        for (i in gameBoard.indices) {
            var xCount = 0
            var oCount = 0
            for (j in 0 until gameBoard[i].size) {
                if (gameBoard[i][j] == 'X') {
                    xCount += 1
                }
                if (gameBoard[i][j] == 'O') {
                    oCount += 1
                }
                if (xCount == THREE) {
                    winner = 'X'
                }
                if (oCount == THREE) {
                    winner = 'O'
                }
            }
            if (winner != null) {
                break
            }
        }
        return winner
    }
    
    private fun checkVertical(gameBoard: Array<CharArray>): Char? {
        return null
    }
    
    private fun checkDiagonal(gameBoard: Array<CharArray>): Char? {
        return null
    }
    
}