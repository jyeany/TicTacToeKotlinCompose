package routing

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import components.board.CenterLayout
import components.board.TicTacToeDisplay
import components.endgame.EndGameScreen
import components.welcome.WelcomeScreen
import services.GameManager

class ViewManager(gameManager: GameManager) {

    private var welcomeScreen: WelcomeScreen = WelcomeScreen(gameManager)
    private val ticTacToeDisplay = TicTacToeDisplay(gameManager)
    private val centerLayout = CenterLayout(ticTacToeDisplay)
    private val endGameScreen = EndGameScreen(gameManager)

    private var route: Route by mutableStateOf(Route.WELCOME)

    @Composable
    fun mainView() {
        val fnUpdateRoute = { r: Route ->
            route = r
        }

        when (route) {
            Route.WELCOME -> welcomeScreen.welcome(fnUpdateRoute)
            Route.GAME -> centerLayout.centeredLayout(fnUpdateRoute)
            Route.END_GAME -> endGameScreen.endGameScreen(fnUpdateRoute)
        }
    }

}