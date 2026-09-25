plugins {
    kotlin("multiplatform")
}

repositories {
    mavenCentral()
}

kotlin {
    js {
        browser()
        binaries.executable()
    }
    sourceSets {
        jsMain {
            dependencies {
                implementation("org.jetbrains.kotlinx:kotlinx-browser:0.5.0")
                implementation("io.ktor:ktor-serialization-kotlinx-json:3.5.1")
                implementation("org.jetbrains.kotlinx:kotlinx-html-js:0.12.0")
            }
        }
        commonMain {
            dependencies {
                implementation(project(":shared"))
            }
        }
    }
}