package util

import kotlinx.browser.document
import org.w3c.dom.*;
import org.w3c.dom.HTMLLinkElement

fun loadStyleSheet(path: String) {
  val head = document.querySelector("head") as HTMLElement
  val link = document.createElement("link") as HTMLLinkElement
  link.rel = "stylesheet"
  link.href = path

  head.appendChild(link)
}