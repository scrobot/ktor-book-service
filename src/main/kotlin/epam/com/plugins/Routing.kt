package epam.com.plugins

import epam.com.authors.authors
import epam.com.books.books
import epam.com.genres.genres
import io.ktor.routing.*
import io.ktor.http.*
import io.ktor.application.*
import io.ktor.response.*
import io.ktor.request.*
import io.ktor.routing.*

fun Application.configureRouting() {

  routing {
    get("/") {
      call.respondText("Hello World!")
    }

    books()
    authors()
    genres()
  }

}
