package epam.com.authors.data

import epam.com.authors.domain.models.AuthorPayload

/**
 *
 *
 * @author Aleksei Scrobot
 */
interface AuthorRepository {
  fun createAuthor(request: AuthorPayload): Author
  fun find(id: Int): Author?
  fun findByIds(id: List<Int>): List<Author>
}

class AuthorDao: AuthorRepository {

  override fun createAuthor(request: AuthorPayload) = Author.new {
    name = request.name
    lastName = request.lastName
    middleName = request.middleName
  }

  override fun find(id: Int) = Author.findById(id)

  override fun findByIds(id: List<Int>) = Author.forIds(id).toList()

}