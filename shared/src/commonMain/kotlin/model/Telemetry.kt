package model

import kotlinx.serialization.Serializable

@Serializable
data class Telemetry(val temperature: Double, 
                     val cpuUsage: Double,
                     val memoryUsage: Double,
                     val diskUsage: Double)