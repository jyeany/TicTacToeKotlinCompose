package services

import kotlin.test.Test
import kotlin.test.assertEquals

class GameWinnerConverterTest {

    @Test
    fun charToWinnerX() {
        val result = charToWinner('X')
        assertEquals(GameWinner.X, result)
    }

    @Test
    fun charToWinnerO() {
        val result = charToWinner('O')
        assertEquals(GameWinner.O, result)
    }

    @Test
    fun charToWinnerDash() {
        val result = charToWinner('-')
        assertEquals(GameWinner.NONE, result)
    }

    @Test
    fun charToWinnerDefault() {
        val result = charToWinner('T')
        assertEquals(GameWinner.DRAW, result)
    }

    @Test
    fun winnerToCharX() {
        val result = winnerToChar(GameWinner.X)
        assertEquals('X', result)
    }

    @Test
    fun winnerToCharO() {
        val result = winnerToChar(GameWinner.O)
        assertEquals('O', result)
    }

    @Test
    fun winnerToCharDraw() {
        val result = winnerToChar(GameWinner.DRAW)
        assertEquals('-', result)
    }

    @Test
    fun winnerToCharNone() {
        val result = winnerToChar(GameWinner.NONE)
        assertEquals('-', result)
    }

}