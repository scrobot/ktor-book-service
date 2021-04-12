package epam.com.books.domain

/**
 *
 *
 * @author Aleksei Scrobot
 */
data class BookRequest(
  val book: BookCreateRequest,
  val genres: List<Int> = listOf(),
  val authors: List<Int> = listOf()
)