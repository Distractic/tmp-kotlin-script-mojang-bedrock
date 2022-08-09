plugins {
    kotlin("js") version "1.7.20-Beta"
}

group = "io.github.universeproject"
version = "1.0.0"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    implementation(npm("@types/mojang-minecraft", "0.1.6"))
    implementation(npm("@types/mojang-minecraft-server-admin", "0.1.0"))
    implementation(npm("@types/mojang-gametest", "0.1.5"))
    implementation(npm("@types/mojang-net", "0.1.0"))
    implementation(npm("@types/mojang-minecraft-ui", "0.1.0"))
}

kotlin {
    js(IR) {
        binaries.executable()
        nodejs()
    }
}