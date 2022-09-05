package components.board

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.dom.Div
import routing.Route

class CenterLayout(private val ticTacToeDisplay: TicTacToeDisplay) {

    @Composable
    fun centeredLayout(updateRouteFn: (r: Route) -> Unit) {
        Div(
            attrs = { classes("mui-container-fluid") }
        ) {
            headerRow()
            boardRow(updateRouteFn)
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
            )
            Div(
                attrs = {classes("mui-col-md-4")}
            ){}
        }
    }

    @Composable
    fun boardRow(updateRouteFn: (r: Route) -> Unit) {
        Div(
            attrs = { classes("mui-row") }
        ) {
            Div(
                attrs = {classes("mui-col-md-4")}
            ) {}
            Div(
                attrs = {classes("mui-col-md-4")}
            ) {
                ticTacToeDisplay.gameBoard(updateRouteFn)
            }
            Div(
                attrs = {classes("mui-col-md-4")}
            ){}
        }
    }
}