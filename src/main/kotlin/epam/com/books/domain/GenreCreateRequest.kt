package epam.com.books.domain

/**
 *
 *
 * @author Aleksei Scrobot
 */
data class GenreCreateRequest(
  val name: String,
  val parentId: Int
)