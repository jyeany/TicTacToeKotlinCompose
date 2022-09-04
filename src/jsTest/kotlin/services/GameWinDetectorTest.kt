package services

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull
import kotlin.test.assertTrue

class GameWinDetectorTest {

    private val gameWinDetector = GameWinDetector()

    @Test
    fun horizontalDefaultBoard() {
        val board = arrayOf(
            charArrayOf('-', '-', '-'),
            charArrayOf('-', '-', '-'),
            charArrayOf('-', '-', '-')
        )
        val winner = gameWinDetector.gameWinner(board)
        assertNull(winner)
    }

    @Test
    fun horizontalWinnerX() {
        val board = arrayOf(
            charArrayOf('-', '-', '-'),
            charArrayOf('X', 'X', 'X'),
            charArrayOf('-', '-', '-')
        )
        val winner = gameWinDetector.gameWinner(board)
        assertEquals('X', winner)
    }

    @Test
    fun horizontalWinnerO() {
        val board = arrayOf(
            charArrayOf('X', 'X', 'O'),
            charArrayOf('X', 'X', 'O'),
            charArrayOf('O', 'O', 'O')
        )
        val winner = gameWinDetector.gameWinner(board)
        assertEquals('O', winner)
    }

}