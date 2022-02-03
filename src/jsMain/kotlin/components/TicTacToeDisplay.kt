package components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import org.jetbrains.compose.web.dom.Button
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Text
import services.GameManager

class TicTacToeDisplay(val gameManager: GameManager) {

    @Composable
    fun gameBoard() {
        for (i in 0 until GameManager.rows) {
            Div {
                for (j in 0 until GameManager.cols) {
                    boardButton(i, j)
                }
            }
        }
    }

    @Composable
    fun boardButton(i: Int, j: Int) {
        var spaceChar: Char by mutableStateOf('-')
        Button(
            attrs = {
                classes("mui-btn", "mui-btn--primary", "mui-btn--raised")
                onClick { spaceChar = gameManager.playSquare(i, j) }
            }
        ) {
            Text(spaceChar.toString())
        }
    }

}