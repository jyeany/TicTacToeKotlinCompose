package components.welcome

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.width
import org.jetbrains.compose.web.dom.*
import routing.Route

class WelcomeScreen {

    @Composable
    fun welcome(fnUpdateRoute: (r: Route) -> Unit) {
        Div(
            attrs = { classes("mui-container-fluid") }
        ) {
            welcomeHeaders()
            val fnClick = { fnUpdateRoute.invoke(Route.GAME) }
            gameModeButton("Random", "mui-btn--primary") { fnClick.invoke() }
            gameModeButton("To Win", "mui-btn--accent") { fnClick.invoke() }
            gameModeButton("Off", "mui-btn--danger") { fnClick.invoke() }
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

    @Composable
    private fun spacerDiv() {
        Div(
            attrs = {classes("mui-col-md-4")}
        ) {}
    }

}