package epam.com.books.data

import epam.com.authors.data.Author
import epam.com.authors.data.AuthorBook
import epam.com.genres.data.BookGenre
import epam.com.genres.data.Genre
import org.jetbrains.exposed.dao.LongEntity
import org.jetbrains.exposed.dao.LongEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.LongIdTable

/**
 *
 *
 * @author Aleksei Scrobot
 */

object Books: LongIdTable() {
  val name = varchar("name", 50)
  val isbn = varchar("isbn", 50)
  val rating = float("rating")
  val annotation = text("annotation")
  val isBestseller = bool("is_bestseller")
  val preview = text("preview_url")
  val value = integer("value")
}

class Book(id: EntityID<Long>) : LongEntity(id) {
  companion object : LongEntityClass<Book>(Books)

  var name by Books.name
  var isbn by Books.isbn
  var rating by Books.rating
  var annotation by Books.annotation
  var isBestseller by Books.isBestseller
  var preview by Books.preview
  var value by Books.value

  var authors by Author via AuthorBook
  var genres by Genre via BookGenre
}