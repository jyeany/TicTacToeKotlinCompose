import components.board.CenterLayout
import components.board.TicTacToeDisplay
import components.appbar
import components.welcome.WelcomeScreen
import org.jetbrains.compose.web.renderComposable
import services.GameManager

fun main() {
    val gameManager = GameManager()
    val welcomeScreen = WelcomeScreen()
    val ticTacToeDisplay = TicTacToeDisplay(gameManager)
    val centerLayout = CenterLayout(ticTacToeDisplay)

    renderComposable(rootElementId = "root") {
        appbar()
        welcomeScreen.welcome()
        centerLayout.centeredLayout()
    }
}

