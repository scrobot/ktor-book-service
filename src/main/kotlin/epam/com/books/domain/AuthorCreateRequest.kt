package epam.com.books.domain

/**
 *
 *
 * @author Aleksei Scrobot
 */
data class AuthorCreateRequest(
  val name: String,
  val lastName: String,
  val middleName: String? = null
)