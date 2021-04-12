package epam.com.authors.domain

import epam.com.authors.data.Author
import epam.com.authors.data.AuthorRepository
import epam.com.authors.domain.mappers.AuthorMapper
import epam.com.authors.domain.models.AuthorDto
import epam.com.authors.domain.models.AuthorPayload
import org.jetbrains.exposed.sql.transactions.transaction

/**
 *
 *
 * @author Aleksei Scrobot
 */
interface AuthorServiceContract {

  fun findAuthors(ids: List<Int>): List<Author>
  fun createAuthor(request: AuthorPayload): AuthorDto

}

class AuthorService(
  private val authorRepository: AuthorRepository,
  private val mapper: AuthorMapper
): AuthorServiceContract {

  override fun findAuthors(ids: List<Int>) = transaction {
    authorRepository.findByIds(ids)
  }

  override fun createAuthor(request: AuthorPayload) = transaction {
    authorRepository.createAuthor(request)
  }.let(mapper::convertToDto)

}