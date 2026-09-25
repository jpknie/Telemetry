import model.Telemetry
import kotlinx.serialization.json.*
import kotlinx.serialization.*
import org.w3c.dom.*;


class TelemetryClient(val url: String = "ws://10.42.0.1:8081/telemetry-stream") {
  fun connect() {
    val ws = WebSocket(url)
    
    ws.onopen = { // tätä event käsittelyä nyt ei kauheasti tarvita, 
    // tai ehkä halutaan alustaa jotain, ja tehdään sille callback var onOpen: Unit?
        event -> 
        println("WS ${event}") 
    }

    ws.onmessage = {
        message ->
            val data = message.data
            if(data is String) {
                val decoded: Telemetry = Json.decodeFromString<Telemetry>(data)
                onTelemetry?.invoke(decoded)
            }
    }
  }
  
  var onTelemetry: ((Telemetry) -> Unit)? = null
    
}
    