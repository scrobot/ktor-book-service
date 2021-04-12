package epam.com.authors.data

import epam.com.books.data.Book
import epam.com.books.data.Books
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.Table

/**
 *
 *
 * @author Aleksei Scrobot
 */

object Authors: IntIdTable() {
  val firstName = varchar("first_name", 50)
  val lastName = varchar("last_name", 50)
  val middleName = varchar("middle_name", 50).nullable()

}

class Author(id: EntityID<Int>) : IntEntity(id) {

  companion object : IntEntityClass<Author>(Authors)

  var name by Authors.firstName
  var lastName by Authors.lastName
  var middleName by Authors.middleName

  val books by Book via AuthorBook

  override fun toString(): String {
    return "Author(name='$name', lastName='$lastName', middleName=$middleName)"
  }

}

object AuthorBook : Table() {
  val book = reference("book", Books)
  val author = reference("author", Authors)
  override val primaryKey = PrimaryKey(book, author, name = "PK_author_book")
}