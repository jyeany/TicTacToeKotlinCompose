import routing.ViewManager
import components.appbar
import org.jetbrains.compose.web.renderComposable
import services.GameManager

fun main() {
    val gameManager = GameManager()
    val viewManager = ViewManager(gameManager)

    renderComposable(rootElementId = "root") {
        appbar()
        viewManager.mainView()
    }
}

