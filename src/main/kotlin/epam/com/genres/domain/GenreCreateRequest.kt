package epam.com.genres.domain

/**
 *
 *
 * @author Aleksei Scrobot
 */
data class GenreCreateRequest(
  val name: String,
  val parentId: Int?
)