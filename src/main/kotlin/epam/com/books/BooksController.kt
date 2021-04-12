package epam.com.books

import epam.com.authors.domain.AuthorServiceContract
import epam.com.books.domain.BookServiceContract
import epam.com.books.domain.BookRequest
import epam.com.genres.domain.GenreServiceContract
import io.ktor.application.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*
import org.koin.ktor.ext.inject

/**
 *
 *
 * @author Aleksei Scrobot
 */
fun Routing.books() {

  val bookService by inject<BookServiceContract>()
  val genreService by inject<GenreServiceContract>()
  val authorService by inject<AuthorServiceContract>()

  get("books/all") {
    val limit = call.request.queryParameters["limit"]?.toInt() ?: 50
    val offset = call.request.queryParameters["offset"]?.toLong() ?: 0

    call.respond(bookService.all(limit, offset))
  }

  post("books") {
    val (request, genres, authors) = call.receive<BookRequest>().let { (request, genreIds, authorIds) ->
      Triple(
        request,
        genreService.findGenres(genreIds),
        authorService.findAuthors(authorIds)
      )
    }

    call.respond(bookService.createBook(request, authors, genres))
  }

}