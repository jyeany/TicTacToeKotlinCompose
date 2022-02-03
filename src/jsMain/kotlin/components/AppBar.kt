package components

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.H1
import org.jetbrains.compose.web.dom.Text

@Composable
fun appbar() {
    Div(
        { classes("mui-appbar")
            style { marginTop((-10).px) }
        }
    ) {
        H1(
            {
                style { margin(10.px) }
            }
        ) {
            Text("Tic Tac Toe")
        }
    }
}