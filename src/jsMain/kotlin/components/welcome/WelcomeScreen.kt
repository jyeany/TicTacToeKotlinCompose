package components.welcome

import androidx.compose.runtime.Composable
import components.spacerDiv
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.width
import org.jetbrains.compose.web.dom.*
import routing.Route
import services.GameManager
import services.players.GameMode

class WelcomeScreen(
    private val gameManager: GameManager
) {

    @Composable
    fun welcome(fnUpdateRoute: (r: Route) -> Unit) {
        Div(
            attrs = { classes("mui-container-fluid") }
        ) {
            welcomeHeaders()
            val fnClick = { fnUpdateRoute.invoke(Route.GAME) }
            gameModeButton("Random", "mui-btn--primary") {
                gameManager.setGameMode(GameMode.RANDOM)
                fnClick.invoke()
            }
            gameModeButton("To Win", "mui-btn--accent") {
                gameManager.setGameMode(GameMode.TO_WIN)
                fnClick.invoke()
            }
            gameModeButton("Off", "mui-btn--danger") {
                gameManager.setGameMode(GameMode.OFF)
                fnClick.invoke()
            }
        }
    }

    @Composable
    private fun gameModeButton(btnText: String, btnTypeCss: String, fnClick: () -> Unit) {
        Div(
            attrs = { classes("mui-row") }
        ) {
            spacerDiv()
            Div(
                attrs = { classes("mui-col-md-4") }
            ) {
                Button(
                    attrs = {
                        classes("mui-btn", btnTypeCss, "mui-btn--raised")
                        style { width(200.px) }
                        onClick { fnClick.invoke() }
                    }
                ) {
                    Text(btnText)
                }
            }
            spacerDiv()
        }
    }

    @Composable
    private fun welcomeHeaders() {
        Div(
            attrs = { classes("mui-row") }
        ) {
            spacerDiv()
            Div(
                attrs = { classes("mui-col-md-4") }
            ) {
                H2 {
                    Text("Computer Player Mode:")
                }
            }
            spacerDiv()
        }
    }

}