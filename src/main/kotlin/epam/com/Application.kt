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

//fun main() {
//
//  embeddedServer(CIO, environment = applicationEngineEnvironment {
//    log = LoggerFactory.getLogger("ktor.application")
//    config = HoconApplicationConfig(ConfigFactory.load())
//
//    module {
//      starter(false)
//    }
//
////    connector {
////      port = 8080
////      host = "127.0.0.1"
////    }
//  }).start(true)
//
//}
