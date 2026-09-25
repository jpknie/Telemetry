import kotlinx.browser.document
import components.Temperature.Temperature

fun main() {
    val temperature = Temperature()

    document.body?.appendChild(
        temperature.render()
    )
}