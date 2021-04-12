package epam.com.plugins

import epam.com.books.books
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
  }

}
