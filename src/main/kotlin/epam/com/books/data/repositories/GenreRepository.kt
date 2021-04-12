package epam.com.books.data.repositories

import epam.com.books.data.models.Genre
import epam.com.books.domain.GenreCreateRequest

/**
 *
 *
 * @author Aleksei Scrobot
 */
interface GenreRepository {
  fun createGenre(request: GenreCreateRequest): Genre
  fun find(id: Int): Genre?
  fun findByIds(ids: List<Int>): List<Genre>
}

class GenreDao : GenreRepository {

  override fun createGenre(request: GenreCreateRequest) = Genre.new {
    name = request.name
    parent = find(request.parentId)
  }

  override fun find(id: Int) = Genre.findById(id)

  override fun findByIds(ids: List<Int>) = Genre.forIds(ids).toList()

}