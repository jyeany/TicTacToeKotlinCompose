package components.endgame

import androidx.compose.runtime.Composable
import components.spacerDiv
import org.jetbrains.compose.web.attributes.disabled
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.width
import org.jetbrains.compose.web.dom.*
import routing.Route
import services.GameManager

class EndGameScreen(
    private val gameManager: GameManager
) {

    @Composable
    fun endGameScreen(updateRouteFn: (r: Route) -> Unit) {
        Div(
            attrs = { classes("mui-container-fluid") }
        ) {
            headerRow()
            gameBoardRow()
            gameOverButtons(updateRouteFn)
        }
    }

    @Composable
    fun headerRow() {
        Div(
            attrs = { classes("mui-row") }
        ) {
            spacerDiv()
            Div(
                attrs = { classes("mui-col-md-4") }
            ) {
                H2 {
                    Text("Game Winner: ${gameManager.gameWinner}")
                }
            }
            spacerDiv()
        }
    }

    @Composable
    fun gameBoardRow() {
        Div(
            attrs = { classes("mui-row") }
        ) {
            spacerDiv()
            Div(
                attrs = { classes("mui-col-md-4") }
            ) {
                gameManager.gameBoard.forEach {
                    it.forEach { c ->
                        Button(
                            attrs = {
                                classes("mui-btn", "mui-btn--gray", "mui-btn--fab")
                                style { width(60.px) }
                                disabled()
                            }
                        ) {
                            Text("$c")
                        }
                    }
                    Br {}
                }
            }
            spacerDiv()
        }
    }

    @Composable
    fun gameOverButtons(updateRouteFn: (r: Route) -> Unit) {
        Div(
            attrs = { classes("mui-row") }
        ) {
            spacerDiv()
            Div(
                attrs = { classes("mui-col-md-4")}
            ) {
                Button(
                    attrs = {
                        classes("mui-btn", "mui-btn--primary", "mui-btn--raised")
                        onClick {
                            gameManager.resetGame()
                            updateRouteFn.invoke(Route.WELCOME)
                        }
                    }
                ) {
                    Text("Play Again")
                }
            }
            spacerDiv()
        }
    }

}