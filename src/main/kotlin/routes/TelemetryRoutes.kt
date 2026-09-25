package routes
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.server.websocket.*
import io.ktor.websocket.*
import kotlinx.serialization.json.Json
import model.Telemetry
import service.TelemetryService

fun Application.configureTelemetryRoutes(telemetryService: TelemetryService) {
  routing {
    get("/telemetry") {
      val result = telemetryService.getTelemetry()
      call.respond(result)
    }
    webSocket("/telemetry-stream") {
      telemetryService.getTelemetryStream().collect {
        measure ->
          val json = Json
          val resultString = json.encodeToString<Telemetry>(measure)
          send(Frame.Text(resultString))
      }
    }
  }
}
