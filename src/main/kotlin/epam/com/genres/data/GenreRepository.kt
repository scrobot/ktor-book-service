package epam.com.genres.data

import epam.com.genres.domain.GenreCreateRequest

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
    parent = request.parentId?.let(::find)
  }

  override fun find(id: Int) = Genre.findById(id)

  override fun findByIds(ids: List<Int>) = Genre.forIds(ids).toList()

}