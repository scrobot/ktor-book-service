package epam.com.books.data.models

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
object Genres: IntIdTable() {
  val name = varchar("name", 50)
  val children = reference("parent_genre", Genres).nullable()
}

class Genre (id: EntityID<Int>) : IntEntity(id) {
  companion object : IntEntityClass<Genre>(Genres)

  var name by Genres.name
  var parent by Genre optionalReferencedOn Genres.children
  val children by Genre optionalReferrersOn Genres.children
  val books by Book via BookGenre
}

object BookGenre : Table() {
  val book = reference("book", Books)
  val genre = reference("genre", Genres)
  override val primaryKey = PrimaryKey(book, genre, name = "PK_book_genre")
}