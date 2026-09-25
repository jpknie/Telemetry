package components.dashboard

import org.w3c.dom.*
import kotlinx.html.*
import kotlinx.html.dom.create
import kotlinx.browser.document
import util.*

import components.temperature.Temperature

class Dashboard {

  val temperature = Temperature()

  init {
    loadStyleSheet("styles/dashboard-component/dashboard.css")
  }
  
  fun render(): HTMLElement = 
    document.create.div(classes = "dashboard") {
      p {
        +"Dashboard"
      }
      with(temperature) {
        render()
      }
    }
}