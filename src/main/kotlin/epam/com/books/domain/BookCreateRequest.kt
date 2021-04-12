package epam.com.books.domain

/**
 *
 *
 * @author Aleksei Scrobot
 */
data class BookCreateRequest(
  val name: String,
  val isbn: String,
  val rating: Float,
  val annotation: String,
  val isBestseller: Boolean,
  val preview: String,
  val value: Int
)