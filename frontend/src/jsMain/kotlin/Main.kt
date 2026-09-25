import kotlinx.browser.document

import components.dashboard.Dashboard

fun main() {
    val dashboard = Dashboard()
       
    document.body?.appendChild(
        dashboard.render()
    )
}