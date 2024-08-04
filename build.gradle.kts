plugins {
    kotlin("jvm") version "2.0.0"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))

    implementation("io.github.serpro69:kotlin-faker:1.6.0")
}

tasks.test {
    useJUnitPlatform()
}