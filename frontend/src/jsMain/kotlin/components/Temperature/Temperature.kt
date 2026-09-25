package components.Temperature

import org.w3c.dom.*
import kotlinx.html.*
import kotlinx.html.dom.create
import kotlinx.browser.document
import util.*

class Temperature {

  init {
    loadStyleSheet("styles/temperature-component/temperature.css")  
  }
  
  fun render(): HTMLElement =
    document.create.div {
      p {
        + "Temperature gauge"
      }
    }
  
}