package service
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import model.Telemetry
import kotlin.random.Random

class TelemetryService {
  fun getTelemetry(): Telemetry =
    Telemetry(
      temperature=33.0,
      cpuUsage=21.0,
      memoryUsage=23.0,
      diskUsage = 55.1
    )
    
    fun getTelemetryStream(): Flow<Telemetry> = flow {
      while(true) {
        val temp = Random.nextDouble() * 100.0
        val cpuUsage = Random.nextDouble() * 100.0
        val memoryUsage = Random.nextDouble() * 100.0
        val diskUsage = Random.nextDouble() * 100.0
        emit((Telemetry(
          temperature=temp,
          cpuUsage=cpuUsage,
          memoryUsage=memoryUsage,
          diskUsage=diskUsage
        )))
        delay(1000)
    }
  }
}