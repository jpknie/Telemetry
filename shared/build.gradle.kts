plugins {
    kotlin("multiplatform")
    kotlin("plugin.serialization")
}

repositories {
  mavenCentral()
}


kotlin {
    jvm()

    js {
        browser()
    }

    sourceSets {
        commonMain {
            dependencies {
                implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.9.0")
            }
        }
    }
}