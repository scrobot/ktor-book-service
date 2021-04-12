package epam.com.books

import epam.com.books.domain.BookContract
import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*
import org.koin.ktor.ext.inject

/**
 *
 *
 * @author Aleksei Scrobot
 */
fun Routing.books() {

  val bookService by inject<BookContract>()

  get("books/all") {
    val limit = call.request.queryParameters["limit"]?.toInt() ?: 50
    val offset = call.request.queryParameters["offset"]?.toLong() ?: 0

    call.respond(bookService.all(limit, offset))
  }
}