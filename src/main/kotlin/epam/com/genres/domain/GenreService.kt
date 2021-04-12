package epam.com.genres.domain

import epam.com.genres.data.Genre
import epam.com.genres.data.GenreRepository
import org.jetbrains.exposed.sql.transactions.transaction

/**
 *
 *
 * @author Aleksei Scrobot
 */
interface GenreServiceContract {

  fun findGenres(ids: List<Int>): List<Genre>
  fun createGenre(request: GenreCreateRequest): Genre

}

class GenreService(
  private val genreRepository: GenreRepository,
): GenreServiceContract {

  override fun findGenres(ids: List<Int>) = transaction {
    genreRepository.findByIds(ids)
  }

  override fun createGenre(request: GenreCreateRequest) = transaction {
    genreRepository.createGenre(request)
  }

}