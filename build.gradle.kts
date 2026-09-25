plugins {
    kotlin("jvm") version "2.4.20"
    kotlin("plugin.serialization") version "2.4.20"
    kotlin("multiplatform") version "2.4.20" apply false
    application
}
repositories {
  mavenCentral()
}

val ktorVersion = "3.5.1"

dependencies {
  implementation("io.ktor:ktor-server-core:$ktorVersion")
  implementation("io.ktor:ktor-server-netty:$ktorVersion")
  implementation("io.ktor:ktor-server-html-builder:$ktorVersion")
  implementation("io.ktor:ktor-server-content-negotiation:$ktorVersion")
  implementation("io.ktor:ktor-serialization-kotlinx-json:$ktorVersion")
  implementation("io.ktor:ktor-server-websockets:$ktorVersion")
  implementation("org.jetbrains.kotlinx:kotlinx-html-jvm:0.12.0")
  implementation("ch.qos.logback:logback-classic:1.5.18")
  // Shared module
  implementation(project(":shared"))
}

application {
  mainClass.set("ApplicationKt")
}

kotlin {
  jvmToolchain(21)
}

tasks.named<JavaExec>("run") {
  systemProperty("io.ktor.development", true)
}
