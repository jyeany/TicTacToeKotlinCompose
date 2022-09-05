package components.endgame

import androidx.compose.runtime.Composable
import components.spacerDiv
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.H2
import org.jetbrains.compose.web.dom.Text
import services.GameManager

class EndGameScreen(
    private val gameManager: GameManager
) {

    @Composable
    fun endGameScreen() {
        Div(
            attrs = { classes("mui-container-fluid") }
        ) {
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
    }

}