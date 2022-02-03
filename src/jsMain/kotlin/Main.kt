import components.CenterLayout
import components.TicTacToeDisplay
import components.appbar
import org.jetbrains.compose.web.renderComposable
import services.GameManager

fun main() {
    val gameManager = GameManager()
    val ticTacToeDisplay = TicTacToeDisplay(gameManager)
    val centerLayout = CenterLayout(ticTacToeDisplay)

    renderComposable(rootElementId = "root") {
        appbar()
        centerLayout.centeredLayout()
    }
}

