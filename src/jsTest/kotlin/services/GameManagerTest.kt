package services

import kotlin.test.Test
import kotlin.test.assertEquals

class GameManagerTest {

    private val gameManager = GameManager()

    @Test
    fun boardInitializes() {
        val gameBoard = gameManager.gameBoard
        for (i in 0 until GameManager.rows) {
            for (j in 0 until GameManager.cols) {
                assertEquals(gameBoard[i][j], '-')
            }
        }
    }

    @Test
    fun playSquareGameWonX() {
        gameManager.currentPlayer = 'X'
        gameManager.playSquare(1, 0)
        gameManager.playSquare(0, 0)
        gameManager.playSquare(1, 1)
        gameManager.playSquare(0, 1)
        val result = gameManager.playSquare(1, 2)
        assertEquals('X', result)
        assertEquals(GameWinner.X, gameManager.gameWinner)
    }

    @Test
    fun playSquareGameWonO() {
        gameManager.currentPlayer = 'X'
        gameManager.playSquare(1, 0)
        gameManager.playSquare(0, 0)
        gameManager.playSquare(1, 1)
        gameManager.playSquare(0, 1)
        gameManager.playSquare(2, 2)
        val result = gameManager.playSquare(0, 2)
        assertEquals('O', result)
        assertEquals(GameWinner.O, gameManager.gameWinner)
    }

}