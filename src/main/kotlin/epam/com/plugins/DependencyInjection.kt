package epam.com.plugins

import io.ktor.application.*
import org.koin.ktor.ext.Koin

/**
 *
 *
 * @author Aleksei Scrobot
 */

fun Application.configureDI() {
  install(Koin) {
//    modules(helloAppModule)
  }
}