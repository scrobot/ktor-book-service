package epam.com.books.data.repositories

import epam.com.books.data.models.Author
import epam.com.books.domain.AuthorCreateRequest

/**
 *
 *
 * @author Aleksei Scrobot
 */
interface AuthorRepository {
  fun createAuthor(request: AuthorCreateRequest): Author
  fun find(id: Int): Author?
  fun findByIds(id: List<Int>): List<Author>
}

class AuthorDao: AuthorRepository {

  override fun createAuthor(request: AuthorCreateRequest) = Author.new {
    name = request.name
    lastName = request.lastName
    middleName = request.middleName
  }

  override fun find(id: Int) = Author.findById(id)

  override fun findByIds(id: List<Int>) = Author.forIds(id).toList()

}