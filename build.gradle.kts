val ktor_version: String by project
val kotlin_version: String by project
val logback_version: String by project
val koin_version: String by project
val exposed_version: String by project
val hocon_mapper_version: String by project


plugins {
  application
  kotlin("jvm") version "1.4.32"
  kotlin("plugin.serialization") version "1.4.32"
}

group = "epam.com"
version = "0.0.1"
application {
  mainClass.set("io.ktor.server.cio.EngineMain")
}

repositories {
  mavenCentral()
  jcenter()
}

dependencies {
  implementation("io.ktor:ktor-serialization:$ktor_version")
  implementation("io.ktor:ktor-server-core:$ktor_version")
  implementation("io.ktor:ktor-jackson:$ktor_version")
  implementation("io.ktor:ktor-server-cio:$ktor_version")
  implementation("ch.qos.logback:logback-classic:$logback_version")
  implementation("org.koin:koin-ktor:$koin_version")
  implementation("org.jetbrains.exposed:exposed-core:$exposed_version")
  implementation("org.jetbrains.exposed:exposed-dao:$exposed_version")
  implementation("org.jetbrains.exposed:exposed-jdbc:$exposed_version")
  implementation("org.postgresql:postgresql:42.2.2")
  implementation("com.github.uharaqo.kotlin-hocon-mapper:kotlin-hocon-mapper:$hocon_mapper_version")
  testImplementation("io.ktor:ktor-server-tests:$ktor_version")
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
  kotlinOptions {
    jvmTarget = "1.8"
  }
}