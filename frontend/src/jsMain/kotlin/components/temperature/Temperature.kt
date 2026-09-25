package components.temperature

import org.w3c.dom.*
import kotlinx.html.*
import kotlinx.html.dom.create
import kotlinx.browser.document
import util.*

class Temperature {

  init {
    loadStyleSheet("styles/temperature-component/temperature.css")  
  }
  
  fun DIV.render() {
    div(classes = "temperature") {
        p {
          +"Temperature gauge"
      }
    }
  }
}