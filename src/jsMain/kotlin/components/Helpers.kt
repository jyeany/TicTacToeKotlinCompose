package components

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.dom.Div

@Composable
fun spacerDiv() {
    Div(
        attrs = {classes("mui-col-md-4")}
    ) {}
}