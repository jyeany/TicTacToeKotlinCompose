package components.welcome

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.width
import org.jetbrains.compose.web.dom.*

class WelcomeScreen {

    @Composable
    fun welcome() {
        Div(
            attrs = { classes("mui-container-fluid") }
        ) {
            welcomeHeaders()
            gameModeButton("Random", "mui-btn--primary")
            gameModeButton("To Win", "mui-btn--accent")
            gameModeButton("Not At All", "mui-btn--danger")
        }
    }

    @Composable
    private fun gameModeButton(btnText: String, btnTypeCss: String) {
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
                H1 {
                    Text("Welcome")
                }
                H2 {
                    Text("How Should The Computer Play?")
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