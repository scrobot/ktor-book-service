package epam.com.authors.domain.models

/**
 *
 *
 * @author Aleksei Scrobot
 */
data class AuthorPayload(
  val name: String,
  val lastName: String,
  val middleName: String? = null
)