package services

fun charToWinner(c: Char): GameWinner {
    return when (c) {
        'X' -> GameWinner.X
        'O' -> GameWinner.O
        '-' -> GameWinner.NONE
        else -> GameWinner.DRAW
    }
}

fun winnerToChar(gameWinner: GameWinner): Char {
    return when (gameWinner) {
        GameWinner.X -> 'X'
        GameWinner.O -> 'O'
        else -> '-'
    }
}
