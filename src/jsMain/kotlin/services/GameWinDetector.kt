package services

class GameWinDetector {

    private val three = 3

    fun gameWinner(gameBoard: Array<CharArray>): GameWinner {
        var gameWinner = GameWinner.NONE
        val diagonal = checkDiagonal(gameBoard)
        if (diagonal != GameWinner.NONE) {
            gameWinner = diagonal
        }

        if (gameWinner == GameWinner.NONE) {
            val horizontalWinner = checkHorizontal(gameBoard)
            if (horizontalWinner != GameWinner.NONE) {
                gameWinner = horizontalWinner
            }
        }

        if (gameWinner == GameWinner.NONE) {
            val verticalWinner = checkVertical(gameBoard)
            if (verticalWinner != GameWinner.NONE) {
                gameWinner = verticalWinner
            }

        }

        if (gameWinner == GameWinner.NONE) {
            val draw = checkDraw(gameBoard)
            if (draw == GameWinner.DRAW) {
                gameWinner = draw
            }
        }

        return gameWinner
    }

    private fun checkDraw(gameBoard: Array<CharArray>): GameWinner {
        var playableCount = 0
        for (i in gameBoard.indices) {
            for (j in 0 until three) {
                if (gameBoard[i][j] == '-') {
                    playableCount += 1
                }
            }
        }
        return if (playableCount == 0) {
            GameWinner.DRAW
        } else {
            GameWinner.NONE
        }
    }
    
    private fun checkHorizontal(gameBoard: Array<CharArray>): GameWinner {
        var winner = GameWinner.NONE
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
                if (xCount == three) {
                    winner = GameWinner.X
                }
                if (oCount == three) {
                    winner = GameWinner.O
                }
            }
            if (winner != GameWinner.NONE) {
                break
            }
        }
        return winner
    }
    
    private fun checkVertical(gameBoard: Array<CharArray>): GameWinner {
        var winner = GameWinner.NONE
        for (i in 0 until three) {
            var xCount = 0
            var oCount = 0
            for (j in 0 until three) {
                val boardPiece = gameBoard[j][i]
                if (boardPiece == 'O') {
                    oCount += 1
                }
                if (boardPiece == 'X') {
                    xCount += 1
                }
                if (xCount == three) {
                    winner = GameWinner.X
                }
                if (oCount == three) {
                    winner = GameWinner.O
                }
            }
            if (winner != GameWinner.NONE) {
                break
            }
        }
        return winner
    }
    
    private fun checkDiagonal(gameBoard: Array<CharArray>): GameWinner {
        val rightToLeft = checkSpaces(
            gameBoard[0][2],
            gameBoard[1][1],
            gameBoard[2][0]
        )
        return checkSpaces(
            gameBoard[0][0],
            gameBoard[1][1],
            gameBoard[2][2]
        ) ?: rightToLeft
    }

    private fun checkSpaces(one: Char, two: Char, three: Char): GameWinner {
        var xCount = 0
        var oCount = 0
        val chars = arrayOf(one, two, three)
        chars.forEach {
            if (it == 'X') {
                xCount += 1
            }
            if (it == 'O') {
                oCount += 1
            }
        }
        return if (xCount == this.three) {
            GameWinner.X
        } else if (oCount == this.three) {
            GameWinner.O
        } else {
            GameWinner.NONE
        }
    }
    
}