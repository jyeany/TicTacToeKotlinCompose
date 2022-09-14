package services

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull

class GameWinDetectorTest {

    private val gameWinDetector = GameWinDetector()

    @Test
    fun gameWinnerDefaultBoard() {
        val board = defaultBoard()
        val winner = gameWinDetector.gameWinner(board)
        assertEquals(GameWinner.NONE, winner)
    }

    @Test
    fun horizontalWinnerX() {
        val board = arrayOf(
            charArrayOf('-', '-', '-'),
            charArrayOf('X', 'X', 'X'),
            charArrayOf('-', '-', '-')
        )
        val winner = gameWinDetector.gameWinner(board)
        assertEquals(GameWinner.X, winner)
    }

    @Test
    fun horizontalWinnerO() {
        val board = arrayOf(
            charArrayOf('X', 'X', 'O'),
            charArrayOf('X', 'X', '-'),
            charArrayOf('O', 'O', 'O')
        )
        val winner = gameWinDetector.gameWinner(board)
        assertEquals(GameWinner.O, winner)
    }

    @Test
    fun verticalBoardWinnerX() {
        val board = arrayOf(
            charArrayOf('X', 'O', 'O'),
            charArrayOf('X', 'X', 'O'),
            charArrayOf('X', 'O', '-')
        )
        val winner = gameWinDetector.gameWinner(board)
        assertEquals(GameWinner.X, winner)
    }

    @Test
    fun verticalBoardWinnerO() {
        val board = arrayOf(
            charArrayOf('X', 'O', 'O'),
            charArrayOf('X', 'X', 'O'),
            charArrayOf('-', 'O', 'O')
        )
        val winner = gameWinDetector.gameWinner(board)
        assertEquals(GameWinner.O, winner)
    }

    @Test
    fun checkDiagonalRightToLeft() {
        val board = arrayOf(
            charArrayOf('X', 'O', 'X'),
            charArrayOf('X', 'X', 'O'),
            charArrayOf('X', 'O', 'O')
        )
        val winner = gameWinDetector.gameWinner(board)
        assertEquals(GameWinner.X, winner)
    }

    @Test
    fun checkDiagonalLeftToRight() {
        val board = arrayOf(
            charArrayOf('O', 'X', 'X'),
            charArrayOf('X', 'O', 'O'),
            charArrayOf('X', 'X', 'O')
        )
        val winner = gameWinDetector.gameWinner(board)
        assertEquals(GameWinner.O, winner)
    }

    private fun defaultBoard(): Array<CharArray> {
        return arrayOf(
            charArrayOf('-', '-', '-'),
            charArrayOf('-', '-', '-'),
            charArrayOf('-', '-', '-')
        )
    }

}