package epam.com

import epam.com.plugins.*
import io.ktor.application.*
import io.ktor.server.cio.*

fun main(args: Array<String>): Unit = EngineMain.main(args)

fun Application.module(testing: Boolean = false) {
  configurePersistenceLayer()
  configureRouting()
  configureMonitoring()
  configureSerialization()
  configureAdministration()
  configureDI()
}
