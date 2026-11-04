plugins {
    kotlin("jvm") version "2.2.20"
}

group = "ie.setu"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}


dependencies {
    testImplementation(kotlin("test"))

    implementation("io.github.oshai:kotlin-logging-jvm:8.0.4")
    implementation("org.slf4j:slf4j-simple:2.0.18")

    // XML and JSON persistence
    implementation("tools.jackson.core:jackson-databind:3.1.4")
    implementation("tools.jackson.module:jackson-module-kotlin:3.1.4")
    implementation("tools.jackson.dataformat:jackson-dataformat-xml:3.1.4")
}


tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(21)
}