package components.board

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.width
import org.jetbrains.compose.web.dom.Button
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.H1
import org.jetbrains.compose.web.dom.Text
import services.GameManager

class TicTacToeDisplay(private val gameManager: GameManager) {

    @Composable
    fun gameBoard() {
        var currentMove by mutableStateOf('X')
        val update = {
            currentMove = gameManager.currentPlayer
        }
        Div {
            H1 {
                Text("Current Move: $currentMove")
            }
            for (i in 0 until GameManager.rows) {
                Div {
                    for (j in 0 until GameManager.cols) {
                        boardButton(i, j, update)
                    }
                }
            }
        }
    }

    @Composable
    fun boardButton(i: Int, j: Int, updateFn: () -> Unit) {
        var spaceChar: Char by mutableStateOf('-')
        Button(
            attrs = {
                classes("mui-btn", "mui-btn--primary", "mui-btn--raised")
                style { width(60.px) }
                onClick {
                    spaceChar = gameManager.playSquare(i, j)
                    updateFn.invoke()
                }
            }
        ) {
            Text(spaceChar.toString())
        }
    }

}