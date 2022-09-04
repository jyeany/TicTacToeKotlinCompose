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

}