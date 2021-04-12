package epam.com.genres

import epam.com.genres.domain.GenreCreateRequest
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
fun Routing.genres() {

  val genreService by inject<GenreServiceContract>()

  post("genres") {
    val request = call.receive<GenreCreateRequest>()

    genreService.createGenre(request)
      .let { call.respond(it) }
  }
}