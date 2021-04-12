package epam.com.authors

import epam.com.authors.domain.AuthorServiceContract
import epam.com.authors.domain.models.AuthorPayload
import io.ktor.application.*
import io.ktor.http.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*
import org.koin.ktor.ext.inject

/**
 *
 *
 * @author Aleksei Scrobot
 */
fun Routing.authors() {

  val authorServiceContract by inject<AuthorServiceContract>()

  post("authors") {
    val request = call.receive<AuthorPayload>()

    authorServiceContract.createAuthor(request)
      .let {
        println(it.toString())
        call.respond(HttpStatusCode.OK, it)
      }
  }
}