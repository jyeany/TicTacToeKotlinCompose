package routing

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import components.board.CenterLayout
import components.board.TicTacToeDisplay
import components.welcome.WelcomeScreen
import org.jetbrains.compose.web.dom.H1
import org.jetbrains.compose.web.dom.Text
import services.GameManager

class ViewManager(private val gameManager: GameManager) {

    @Composable
    fun mainView() {
        val route: Route by mutableStateOf(Route.WELCOME)
        val welcomeScreen = WelcomeScreen()
        val ticTacToeDisplay = TicTacToeDisplay(gameManager)
        val centerLayout = CenterLayout(ticTacToeDisplay)

        when (route) {
            Route.WELCOME -> welcomeScreen.welcome()
            Route.GAME -> centerLayout.centeredLayout()
            Route.END_GAME -> H1 { Text("Game Over ")}
        }
    }

}