package components

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.H1
import org.jetbrains.compose.web.dom.Text

class CenterLayout(private val ticTacToeDisplay: TicTacToeDisplay) {

    @Composable
    fun centeredLayout() {
        Div(
            attrs = { classes("mui-container-fluid") }
        ) {
            headerRow()
            boardRow()
        }
    }

    @Composable
    fun headerRow() {
        Div(
            attrs = { classes("mui-row") }
        ) {
            Div(
                attrs = {classes("mui-col-md-4")}
            ) {}
            Div(
                attrs = {classes("mui-col-md-4")}
            ) {
                H1 {
                    Text("Current Move: ${ticTacToeDisplay.gameManager.currentPlayer}")
                }
            }
            Div(
                attrs = {classes("mui-col-md-4")}
            ){}
        }
    }

    @Composable
    fun boardRow() {
        Div(
            attrs = { classes("mui-row") }
        ) {
            Div(
                attrs = {classes("mui-col-md-4")}
            ) {}
            Div(
                attrs = {classes("mui-col-md-4")}
            ) {
                ticTacToeDisplay.gameBoard()
            }
            Div(
                attrs = {classes("mui-col-md-4")}
            ){}
        }
    }
}