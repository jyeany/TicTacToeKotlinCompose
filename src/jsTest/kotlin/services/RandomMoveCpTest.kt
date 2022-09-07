package services

import kotlin.test.Test
import kotlin.test.assertEquals

class RandomMoveCpTest {

    private val randomMoveCp = RandomMoveCp()

    @Test
    fun makeMoveChoosesOnlyAvailable() {
        val board = arrayOf(
            charArrayOf('X', 'O', 'X'),
            charArrayOf('O', 'X', 'O'),
            charArrayOf('O', 'X', '-')
        )
        val resultMove = randomMoveCp.makeMove(board)
        assertEquals(2, resultMove.x)
        assertEquals(2, resultMove.y)
        assertEquals('O', resultMove.c)
    }

}