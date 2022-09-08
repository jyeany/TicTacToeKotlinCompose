package components.board

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.H2
import org.jetbrains.compose.web.dom.Text
import routing.Route
import services.GameManager

class TicTacToeDisplay(private val gameManager: GameManager) {

    private var boardMap = mutableMapOf<Pair<Int, Int>, BoardButton>()

    @Composable
    fun gameBoard(updateRouteFn: (r: Route) -> Unit) {
        var currentMove by mutableStateOf('X')
        val updateFn = {
            if (gameManager.gameWinner == null) {
                if (gameManager.hasComputerPlayer()) {
                    val move = gameManager.computerPlaySquare()
                    boardMap[Pair(move.x, move.y)]?.spaceChar = move.c
                }
                currentMove = gameManager.currentPlayer
            } else {
                updateRouteFn.invoke(Route.END_GAME)
            }
        }
        Div {
            H2 {
                Text("Current Move: $currentMove")
            }
            for (i in 0 until GameManager.rows) {
                Div {
                    for (j in 0 until GameManager.cols) {
                        val boardButton = BoardButton(gameManager)
                        boardMap[Pair(i, j)] = boardButton
                        boardButton.boardButton(i, j, updateFn)
                    }
                }
            }
        }
    }

}