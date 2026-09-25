import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.html.*
import io.ktor.server.netty.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.server.routing.*
import io.ktor.server.websocket.*
import kotlinx.html.p
import kotlinx.serialization.json.Json
import routes.configureTelemetryRoutes
import service.TelemetryService

fun main() {
  embeddedServer(
    Netty,
    port = 8081,
    host = "0.0.0.0",
    module = Application::module,
    watchPaths = listOf("classes")
  ).start(wait = true)
}

suspend fun Application.module() {
    install(WebSockets)
    install(ContentNegotiation) {  
      json(Json {
            prettyPrint = true
        }, ContentType.Application.Json)
    }
    
    val telemetryService = TelemetryService()
    
    configureTelemetryRoutes(telemetryService)
    routing {
      get("/") {
        call.respondHtml {
          p {
            +"Hello world"
          }
        }
      }
    }
    
}
