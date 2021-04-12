package epam.com.books.domain

import epam.com.books.data.models.Book
import epam.com.books.data.repositories.AuthorRepository
import epam.com.books.data.repositories.BookRepository
import epam.com.books.data.repositories.GenreRepository
import org.jetbrains.exposed.sql.transactions.transaction

/**
 *
 *
 * @author Aleksei Scrobot
 */

interface BookContract {
  fun all(limit: Int, offset: Long): List<Book>
  fun createBook(request: BookCreateRequest, authorIds: List<Int>, genreIds: List<Int>): Book
}

class BookService(
  private val bookRepository: BookRepository,
  private val genreRepository: GenreRepository,
  private val authorRepository: AuthorRepository
): BookContract {

  override fun all(limit: Int, offset: Long) = transaction {
    bookRepository.all(limit, offset)
  }

  override fun createBook(request: BookCreateRequest, authorIds: List<Int>, genreIds: List<Int>) = Pair(
    genreRepository.findByIds(genreIds),
    authorRepository.findByIds(authorIds)
  ).let { (genres, authors) ->
    bookRepository.create(request, authors, genres)
  }

}