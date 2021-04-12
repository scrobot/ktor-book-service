package epam.com.books.domain

import epam.com.authors.data.Author
import epam.com.books.data.Book
import epam.com.authors.data.AuthorRepository
import epam.com.books.data.BookRepository
import epam.com.genres.data.Genre
import org.jetbrains.exposed.sql.transactions.transaction

/**
 *
 *
 * @author Aleksei Scrobot
 */

interface BookServiceContract {
  fun all(limit: Int, offset: Long): List<Book>
  fun view(id: Long): Book?
  fun createBook(request: BookCreateRequest, authors: List<Author>, genres: List<Genre>): Book

}

class BookService(
  private val bookRepository: BookRepository
): BookServiceContract {

  override fun all(limit: Int, offset: Long) = transaction {
    bookRepository.all(limit, offset)
  }

  override fun view(id: Long) = transaction {
    bookRepository.find(id)
  }

  override fun createBook(request: BookCreateRequest, authors: List<Author>, genres: List<Genre>) = transaction {
    bookRepository.create(request, authors, genres)
  }

}