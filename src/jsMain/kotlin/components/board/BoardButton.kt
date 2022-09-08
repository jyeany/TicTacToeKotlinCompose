package components.board

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.width
import org.jetbrains.compose.web.dom.Button
import org.jetbrains.compose.web.dom.Text
import services.GameManager

class BoardButton(private val gameManager: GameManager) {

    var spaceChar: Char by mutableStateOf('-')

    @Composable
    fun boardButton(i: Int, j: Int, updateFn: () -> Unit) {
        val btnStyle = buttonStyle(spaceChar)
        Button(
            attrs = {
                classes("mui-btn", btnStyle, "mui-btn--fab")
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

    private fun buttonStyle(c: Char): String {
        return when (c) {
            'X' -> "mui-btn--primary"
            'O' -> "mui-btn--danger"
            else -> "mui-btn--gray"
        }
    }

}