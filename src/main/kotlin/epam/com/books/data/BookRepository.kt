package epam.com.books.data

import epam.com.authors.data.Author
import epam.com.genres.data.Genre
import epam.com.books.domain.BookCreateRequest
import org.jetbrains.exposed.sql.SizedCollection

/**
 *
 *
 * @author Aleksei Scrobot
 */
interface BookRepository {
  fun all(limit: Int, offset: Long): List<Book>
  fun find(id: Long): Book?
  fun create(request: BookCreateRequest, authors: List<Author>, genres: List<Genre>): Book
}

class BookDao : BookRepository {

  override fun all(limit: Int, offset: Long) = Book.all()
    .limit(limit, offset)
    .toList()

  override fun find(id: Long) = Book.findById(id)

  override fun create(request: BookCreateRequest, authors: List<Author>, genres: List<Genre>) = Book.new {
    name = request.name
    isbn = request.isbn
    rating = request.rating
    annotation = request.annotation
    isBestseller = request.isBestseller
    preview = request.preview
    value = request.value

    this.authors = SizedCollection(authors)
    this.genres = SizedCollection(genres)
  }

}