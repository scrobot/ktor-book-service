package epam.com.plugins

import epam.com.authors.di.authorsModule
import epam.com.books.di.bookModule
import epam.com.genres.di.genresModule
import io.ktor.application.*
import org.koin.ktor.ext.Koin

/**
 *
 *
 * @author Aleksei Scrobot
 */

fun Application.configureDI() {
  install(Koin) {
    modules(bookModule)
    modules(authorsModule)
    modules(genresModule)
  }
}